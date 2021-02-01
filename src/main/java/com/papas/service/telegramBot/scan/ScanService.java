package com.papas.service.telegramBot.scan;

import com.papas.service.telegramBot.user.User;
import com.papas.service.telegramBot.user.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScanService {
    private UserRepository userRepository;
    private final Logger logger = LogManager.getLogger();

    public ScanService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public BotApiMethod<?> searchModels(Update update) {
        Integer userId = update.getCallbackQuery().getFrom().getId();
        User user = userRepository.findByTelegramId(userId).orElse(null);
        List<Integer> hashTagIds = user == null ? null : user.getHashTagIds();
        return getModel(hashTagIds);
    }

    private BotApiMethod<?> getModel(List<Integer> hashTagIds) {
        String path = null;
        try {
            List<Path> contentModelPathList = Files.walk(Paths.get("")).filter(Files::isRegularFile).collect(Collectors.toList());
        } catch (IOException e) {
        logger.warn("Invalid path to model {}", path);
        }
        return null;
    }
}
