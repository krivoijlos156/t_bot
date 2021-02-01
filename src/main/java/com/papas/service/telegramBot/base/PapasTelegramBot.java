package com.papas.service.telegramBot.base;

import com.papas.service.telegramBot.message.MessageService;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

public class PapasTelegramBot extends TelegramWebhookBot {
    private MessageService messageService;
    public String botToken;
    public String userName;
    public String webHookPath;


    public PapasTelegramBot() {
    }

    public PapasTelegramBot(MessageService messageService, String botToken, String userName, String webHookPath) {
        this.messageService = messageService;
        this.botToken=botToken;
        this.userName = userName;
        this.webHookPath = webHookPath;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        BotApiMethod<?> sendMessage = messageService.handlerUpdate(update);
        return sendMessage;
    }

    @Override
    public String getBotPath() {
        return webHookPath;
    }

    @Override
    public String getBotUsername() {
        return userName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setWebHookPath(String webHookPath) {
        this.webHookPath = webHookPath;
    }
}
