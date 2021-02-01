package com.papas.service.telegramBot.util;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.Arrays;
import java.util.List;

import static com.papas.service.telegramBot.util.EmojiConst.BALL_EMOJI;

public class ButtonConst {
    public static InlineKeyboardButton B_1 = new InlineKeyboardButton("Стереть");
    public static InlineKeyboardButton B_2 = new InlineKeyboardButton("Взглянуть");
    public static InlineKeyboardButton B0 = new InlineKeyboardButton("sweet");
    public static InlineKeyboardButton B1 = new InlineKeyboardButton("black");
    public static InlineKeyboardButton B2 = new InlineKeyboardButton("new");
    public static InlineKeyboardButton B3 = new InlineKeyboardButton("cute");
    public static InlineKeyboardButton B4 = new InlineKeyboardButton("ragnarok");
    public static InlineKeyboardButton B5 = new InlineKeyboardButton("hug");

    public static InlineKeyboardButton B0E = new InlineKeyboardButton("sweet" + BALL_EMOJI);
    public static InlineKeyboardButton B1E = new InlineKeyboardButton("black" + BALL_EMOJI);
    public static InlineKeyboardButton B2E = new InlineKeyboardButton("new" + BALL_EMOJI);
    public static InlineKeyboardButton B3E = new InlineKeyboardButton("cute" + BALL_EMOJI);
    public static InlineKeyboardButton B4E = new InlineKeyboardButton("ragnarok" + BALL_EMOJI);
    public static InlineKeyboardButton B5E = new InlineKeyboardButton("hug" + BALL_EMOJI);


    public static List<InlineKeyboardButton> buttons1 = Arrays.asList(B0, B1, B2, B3, B4, B5);
    public static List<InlineKeyboardButton> buttons2 = Arrays.asList(B0E, B1E, B2E, B3E, B4E, B5E);

    static {
        B_1.setCallbackData("-1");
        B_2.setCallbackData("-2");
        B0.setCallbackData("0");
        B1.setCallbackData("1");
        B2.setCallbackData("2");
        B3.setCallbackData("3");
        B4.setCallbackData("4");
        B5.setCallbackData("5");
    }

    static {
        B0E.setCallbackData("0");
        B1E.setCallbackData("1");
        B2E.setCallbackData("2");
        B3E.setCallbackData("3");
        B4E.setCallbackData("4");
        B5E.setCallbackData("5");
    }
}
