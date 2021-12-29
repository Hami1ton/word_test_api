package com.kugutsu.wordTest.domain.model.examResult;

import java.util.List;

/**
 * 試験結果
 */
public class ExamResult {

    private String id;

    private String userId;

    private int score;

    private List<ClientAnswer> answers;

    @Override
    public String toString() {
        return "ClientAnswer{" +
                "id=" + id + "," +
                "userId=" + userId + "," +
                "回答=" + score + "," +
                '}';
    }
}
