package com.papas.service.telegramBot.start;

import com.papas.service.telegramBot.search.ButtonService;
import com.papas.service.telegramBot.util.EmojiService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.ArrayList;

@Component
public class TextService {
    private EmojiService emojiService;
    private ButtonService buttonService;

    public TextService(EmojiService emojiService, ButtonService buttonService) {
        this.emojiService = emojiService;
        this.buttonService = buttonService;
    }

    public SendMessage handlerText(Message message) {
        switch (message.getText()) {
            case "/1":
                return createMsg(message, "на кл посадим");
            case "/2":
                return createMsg(message, "по лбу на");
            case "/keyboard":
                InlineKeyboardMarkup inlineKeyboard = buttonService.createInlineKeyboard(new ArrayList<>());
                SendMessage test = createMsg(message, "test");
                test.setReplyMarkup(inlineKeyboard);
                return test;
            default:
                return createMsg(message, "давай что-нибудь нормальное");
        }
    }

    private SendMessage createMsg(Message message, String text) {
        Long chatId = message.getChatId();
        return new SendMessage(chatId.toString(), text);
    }
}
