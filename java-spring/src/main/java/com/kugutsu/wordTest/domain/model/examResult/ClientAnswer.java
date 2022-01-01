package com.kugutsu.wordTest.domain.model.examResult;

import lombok.Getter;
import org.apache.commons.validator.*;

/**
 * 回答
 */
@Getter
public class ClientAnswer {

    private String id;

    private String selectedMeaning;

    public ClientAnswer(String id, String selectedMeaning) {
        nullCheck(id, selectedMeaning);
        this.id = id;
        this.selectedMeaning = selectedMeaning;
    }

    private void nullCheck(String id, String selectedMeaning) {
        // TODO ドメインプリミティブにする
        if (GenericValidator.isBlankOrNull(id) ||
                GenericValidator.isBlankOrNull(selectedMeaning)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "ClientAnswer{" +
                "id=" + id + "," +
                "回答=" + selectedMeaning +
                '}';
    }
}
