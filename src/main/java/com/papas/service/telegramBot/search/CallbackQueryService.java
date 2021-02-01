package com.papas.service.telegramBot.search;

import com.papas.service.telegramBot.scan.ScanService;
import com.papas.service.telegramBot.user.StateChat;
import com.papas.service.telegramBot.user.User;
import com.papas.service.telegramBot.user.UserRepository;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.toIntExact;

@Component
public class CallbackQueryService {
    private UserRepository userRepository;
    private ButtonService buttonService;
    private ScanService scanService;

    public CallbackQueryService(UserRepository userRepository,
                                ButtonService buttonService,
                                ScanService scanService) {
        this.userRepository = userRepository;
        this.buttonService = buttonService;
        this.scanService = scanService;
    }

    public BotApiMethod<?> handlerCallbackQuery(Update update) {
        String call_data = update.getCallbackQuery().getData();
        int hashTagId = whatNumeric(call_data);
        if (hashTagId == -2) {
            return scanService.searchModels(update);
        }
        return changeCallbackQuery(update, hashTagId);
    }

    public BotApiMethod<?> changeCallbackQuery(Update update, int hashTagId) {
        CallbackQuery updateCallbackQuery = update.getCallbackQuery();
        Long chat_id = updateCallbackQuery.getMessage().getChatId();

        long message_id = updateCallbackQuery.getMessage().getMessageId();
        int telegramId = updateCallbackQuery.getFrom().getId();
        List<Integer> hashTagIds = new ArrayList<>();

        if (hashTagId >= 0) {
            hashTagIds = addHashTagIds(telegramId, hashTagId);
        } else {
            clearHashTagIds(telegramId);
        }

        InlineKeyboardMarkup inlineKeyboard = buttonService.createInlineKeyboard(hashTagIds);
        EditMessageReplyMarkup changeMsg = new EditMessageReplyMarkup();
        changeMsg.setChatId(chat_id.toString());
        changeMsg.setMessageId(toIntExact(message_id));
        changeMsg.setReplyMarkup(inlineKeyboard);
        return changeMsg;
    }


    public BotApiMethod<?> createCallbackQuery(Update update) {
        Long chat_id = update.getCallbackQuery().getMessage().getChatId();
        InlineKeyboardMarkup inlineKeyboard = buttonService.createInlineKeyboard(new ArrayList<>());
        return SendMessage.builder().chatId(chat_id.toString()).replyMarkup(inlineKeyboard).build();
    }

    private void clearHashTagIds(int telegramId) {
        User user = getUser(telegramId);
        user.setHashTagIds(new ArrayList<>());
        userRepository.save(user);
    }

    private List<Integer> addHashTagIds(int telegramId, int hashTagId) {
        User user = getUser(telegramId);
        List<Integer> hashTagIds = user.getHashTagIds();
        hashTagIds.add(hashTagId);
        user.setHashTagIds(hashTagIds);
        return userRepository.save(user).getHashTagIds();
    }

    private User getUser(int telegramId) {
        User user;
        user = userRepository.findByTelegramId(telegramId).orElse(null);
        if (user == null) {
            user = new User(telegramId);
            user.setStateChat(StateChat.search);
        }
        return user;
    }

    public static int whatNumeric(String strNum) {
        int num;
        try {
            num = Integer.parseInt(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return -1;
        }
        return num;
    }
}
