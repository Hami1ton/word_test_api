package com.kugutsu.wordTest.domain.model.exam;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

/**
 * 問題
 */
@AllArgsConstructor
@Data
public class Mondai {

    /* 英単語 */
    private String word;

    /* 選択肢1 */
    private String choice1;

    /* 選択肢2 */
    private String choice2;

    /* 選択肢3 */
    private String choice3;


    @Override
    public String toString() {
        return "Mondai{" +
                "英単語=" + word + "," +
                "選択肢1" + choice1 + "," +
                "選択肢2" + choice2 + "," +
                "選択肢3" + choice3 +
                '}';
    }
}
