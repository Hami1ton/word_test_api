package com.kugutsu.wordTest.domain.model.examResult;

import org.apache.commons.validator.*;

/**
 * 回答
 */
public class ClientAnswer {

    private String word;

    private String selectedMeaning;

    public ClientAnswer(String word, String selectedMeaning) {
        nullCheck(word, selectedMeaning);
        this.word = word;
        this.selectedMeaning = selectedMeaning;
    }

    private void nullCheck(String word, String selectedMeaning) {
        // TODO ドメインプリミティブにする
        if (GenericValidator.isBlankOrNull(word) ||
                GenericValidator.isBlankOrNull(selectedMeaning)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "ClientAnswer{" +
                "英単語=" + word + "," +
                "回答=" + selectedMeaning +
                '}';
    }
}
