package com.papas.service.telegramBot.base;

import com.papas.service.telegramBot.base.PapasTelegramBot;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class PapasController {
    public final PapasTelegramBot papasTelegramBot;

    public PapasController(PapasTelegramBot papasTelegramBot) {
        this.papasTelegramBot = papasTelegramBot;
    }

    @PostMapping
    public BotApiMethod<?> getUp(@RequestBody Update update) {
        return papasTelegramBot.onWebhookUpdateReceived(update);
    }
}
