package com.papas.service.telegramBot;

import com.papas.service.telegramBot.base.PapasTelegramBot;
import com.papas.service.telegramBot.message.MessageService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
@ConfigurationProperties(prefix = "telegram")
public class BinConfig {
    public String botToken;
    public String botName;
    public String webHookPath;

    @Bean
    public PapasTelegramBot myPapasTelegramBot(MessageService messageService) {
        PapasTelegramBot papasBot = new PapasTelegramBot(messageService, botToken, botName, webHookPath);
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(papasBot, new SetWebhook());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return papasBot;
    }

    public String getBotToken() {
        return botToken;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    public String getBotName() {
        return botName;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }

    public String getWebHookPath() {
        return webHookPath;
    }

    public void setWebHookPath(String webHookPath) {
        this.webHookPath = webHookPath;
    }
}
