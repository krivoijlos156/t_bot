package com.papas.service.telegramBot.util;

import org.springframework.stereotype.Service;

@Service
public class EmojiService {
    String ballEmoji = "\u26BD";
    String bananaEmoji = "\uD83C\uDF4C";
    String koreanFlagEmoji = "\uD83C\uDDF0\uD83C\uDDF7";

    public String getBallEmoji() {
        return ballEmoji;
    }

    public void setBallEmoji(String ballEmoji) {
        this.ballEmoji = ballEmoji;
    }

    public String getBananaEmoji() {
        return bananaEmoji;
    }

    public void setBananaEmoji(String bananaEmoji) {
        this.bananaEmoji = bananaEmoji;
    }

    public String getKoreanFlagEmoji() {
        return koreanFlagEmoji;
    }

    public void setKoreanFlagEmoji(String koreanFlagEmoji) {
        this.koreanFlagEmoji = koreanFlagEmoji;
    }
}
