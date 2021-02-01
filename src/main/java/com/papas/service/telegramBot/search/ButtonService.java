package com.papas.service.telegramBot.search;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.papas.service.telegramBot.util.ButtonConst.*;

@Service
public class ButtonService {

    public List<InlineKeyboardButton> buttons;


    public InlineKeyboardMarkup createInlineKeyboard(List<Integer> hashTagIds) {
        buttons = createActualKeyboard(hashTagIds);

        return new InlineKeyboardMarkup(Arrays.asList(
                Arrays.asList(buttons.get(0), buttons.get(1), buttons.get(2)),
                Arrays.asList(buttons.get(3), buttons.get(4), buttons.get(5)),
                Arrays.asList(B_2),
                Arrays.asList(B_1)
        ));
    }

    private List<InlineKeyboardButton> createActualKeyboard(List<Integer> hashTagIds) {
        List<InlineKeyboardButton> buttons = new ArrayList<>();
        for (int a = 0; a < buttons1.size(); a++) {
            if (hashTagIds.contains(a))
                buttons.add(buttons2.get(a));
            else
                buttons.add(buttons1.get(a));
        }
        return buttons;
    }

}
