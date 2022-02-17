package com.kugutsu.word_test.domain.model.exam;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 問題
 */
@AllArgsConstructor
@Data
public class Mondai {

    /* id */
    private String id;

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
                "id=" + id + "," +
                "英単語=" + word + "," +
                "選択肢1" + choice1 + "," +
                "選択肢2" + choice2 + "," +
                "選択肢3" + choice3 +
                '}';
    }
}
