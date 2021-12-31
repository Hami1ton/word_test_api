package com.kugutsu.wordTest.domain.model.examResult;

import lombok.Getter;

import java.util.List;
import java.util.Map;

/**
 * 試験結果
 */
public class ExamResult {

    private String id;

    private String userId;

    private List<ClientAnswer> clientAnswerList;

    private Map<String, String> correctAnswerMap;

    @Getter
    private final int score;

    public ExamResult(String userId, List<ClientAnswer> clientAnswerList
    , Map<String, String> correctAnswerMap) {
        uuid();
        this.userId = userId;
        this.clientAnswerList = clientAnswerList;
        this.correctAnswerMap = correctAnswerMap;
        this.score = score();
    }

    private void uuid() {
        this.id = "";
    }

    private int score() {
        int result = 0;
        for(ClientAnswer clientAnswer : clientAnswerList) {
            String word = clientAnswer.getWord();
            String selectedMeaning = clientAnswer.getSelectedMeaning();
            String correctMeaning = correctAnswerMap.get(word);
            if (selectedMeaning.equals(correctMeaning)) {
                result += 1;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "ClientAnswer{" +
                "id=" + id + "," +
                "userId=" + userId + "," +
                "スコア=" + score + "," +
                "回答=" + clientAnswerList +
                '}';
    }
}
