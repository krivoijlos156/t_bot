package com.papas.service.telegramBot.start;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Arrays;

import static com.papas.service.telegramBot.util.ButtonConst.B_1;

@Service
public class StartService {


    public SendMessage getStart(Message message) {
        SendMessage sendMessage = createMsg(message,
                "Приветсвую! Помогу сделать выбор не менее приятным, чем процесс. " +
                "На следующей странице выбери нужные hashtags и нажми \"искать\", " +
                "чтобы провалиться в мир удобства и соблазна.");
        sendMessage.setReplyMarkup(createInlineKeyboard());
        return sendMessage;
    }

    private InlineKeyboardMarkup createInlineKeyboard() {
        return new InlineKeyboardMarkup(Arrays.asList(
                Arrays.asList(InlineKeyboardButton.builder().text("Начать поиск").callbackData("begin").build())
        ));
    }

    private SendMessage createMsg(Message message, String text) {
        Long chatId = message.getChatId();
        return new SendMessage(chatId.toString(), text);
    }
}
