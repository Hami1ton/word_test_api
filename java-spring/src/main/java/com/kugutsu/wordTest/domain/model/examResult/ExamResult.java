package com.kugutsu.wordTest.domain.model.examResult;

import lombok.Getter;

import java.util.List;

/**
 * 試験結果
 */
public class ExamResult {

    private String id;

    private String userId;

    @Getter
    private final int score;

    private List<ClientAnswer> clientAnswerList;

    public ExamResult(String userId, List<ClientAnswer> clientAnswerList) {
        uuid();
        this.userId = userId;
        this.clientAnswerList = clientAnswerList;
        this.score = score();
    }

    private void uuid() {
        this.id = "";
    }

    private int score() {
        return 0;
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
