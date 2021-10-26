package com.kugutsu.wordTest.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Random;

@AllArgsConstructor
@Data
public class Problem {

    /* 英単語ID */
    private String id;

    /* 英単語 */
    private String word;

    /* 選択肢1 */
    private String choice1;

    /* 選択肢2 */
    private String choice2;

    /* 選択肢3 */
    private String choice3;

    /*
     *
     * 問題を新規に作成
     * */
    public static Problem createNewProblem(String id, String word, String meaning, String bluff1, String bluff2) {
        String choice1;
        String choice2;
        String choice3;
        // 選択肢の配置にランダム性を持たせるための処理
        Random rand = new Random();
        int num = rand.nextInt(3);
        if (num == 0) {
            choice1 = meaning;
            choice2 = bluff1;
            choice3 = bluff2;
        } else if (num == 1) {
            choice1 = bluff2;
            choice2 = meaning;
            choice3 = bluff1;
        } else {
            choice1 = bluff1;
            choice2 = bluff2;
            choice3 = meaning;
        }

        return new Problem(id, word, choice1, choice2, choice3);
    }
}
