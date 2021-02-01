package com.papas.service.telegramBot.message;

import com.papas.service.telegramBot.search.CallbackQueryService;
import com.papas.service.telegramBot.start.StartService;
import com.papas.service.telegramBot.start.TextService;
import com.papas.service.telegramBot.user.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class MessageService {
    private TextService textService;
    private CallbackQueryService callbackQueryService;
    private UserRepository userRepository;
    private StartService startService;
    private final Logger logger = LogManager.getLogger();

    public MessageService(TextService textService,
                          CallbackQueryService callbackQueryService,
                          UserRepository userRepository,
                          StartService startService) {
        this.textService = textService;
        this.callbackQueryService = callbackQueryService;
        this.userRepository = userRepository;
        this.startService = startService;
    }

    public BotApiMethod<?> handlerUpdate(Update update) {
        Message message = update.getMessage();
//        int telegramId = message.getFrom().getId();
//        User user = userRepository.findByTelegramId(telegramId).orElse(null);
//        if (user==null){
//        }
        logger.info("Text:{}, have CallbackQuery up: {}", update.getMessage().getText(), update.hasCallbackQuery());
        if (message != null && message.hasText()) {
            return handlerText(update);
        } else if (update.hasCallbackQuery()) {
            return handlerCallbackQuery(update);
        }
        return null;
    }


    public BotApiMethod<?> handlerText(Update update) {
        Message message = update.getMessage();
        switch (message.getText()) {
            case "/start":
                return startService.getStart(message);
            case "begin":
                return handlerCallbackQuery(update);
            default:
                return new SendMessage(message.getChatId().toString(), "давай что-нибудь нормальное");
        }

    }


    public BotApiMethod<?> handlerCallbackQuery(Update update) {
        if (update.getMessage()!=null)
            return callbackQueryService.createCallbackQuery(update);
        return callbackQueryService.handlerCallbackQuery(update);
    }


//    public void setButtons(SendMessage sendMessage) {
//        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
//        sendMessage.setReplyMarkup(keyboardMarkup);
//        keyboardMarkup.setResizeKeyboard(true);
//        keyboardMarkup.setOneTimeKeyboard(false);
//        keyboardMarkup.setSelective(true);
//
//        List<KeyboardRow> keyboardRowList = new ArrayList<>();
//
//        KeyboardRow keyboardFirstRow = new KeyboardRow();
//        keyboardFirstRow.add(new KeyboardButton("/1"));
//        keyboardFirstRow.add(new KeyboardButton("/2"));
//        keyboardRowList.add(keyboardFirstRow);
//
//        keyboardMarkup.setKeyboard(keyboardRowList);
//    }
}
