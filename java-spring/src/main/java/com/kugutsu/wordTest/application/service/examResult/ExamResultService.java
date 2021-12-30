package com.kugutsu.wordTest.application.service.examResult;

import com.kugutsu.wordTest.domain.model.examResult.ClientAnswer;
import com.kugutsu.wordTest.domain.model.examResult.ExamResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ExamResultService {

    public int score(Map<String, String> answers) {
        // 結果生成
        List<ClientAnswer> clientAnswerList = convertToClientAnswer(answers);
        // 永続化
        ExamResult result = new ExamResult("userId", clientAnswerList);

        // スコア返却
        return result.getScore();
    }

    private List<ClientAnswer> convertToClientAnswer(Map<String, String> answers) {
        List<ClientAnswer> list = new ArrayList<>();

        for (String word : answers.keySet()) {
            String selectedMeaning = answers.get(word);

            list.add(new ClientAnswer(word, selectedMeaning));
        }
        return list;
    }
}
