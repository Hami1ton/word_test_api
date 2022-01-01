package com.kugutsu.wordTest.application.service.examResult;

import com.kugutsu.wordTest.application.service.vocabularyBook.VocabularyBookRepository;
import com.kugutsu.wordTest.domain.model.examResult.ClientAnswer;
import com.kugutsu.wordTest.domain.model.examResult.ExamResult;
import com.kugutsu.wordTest.domain.model.vocabularyBook.VocabularyBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExamResultService {

    VocabularyBookRepository vocabularyBookRepository;

    public ExamResultService(VocabularyBookRepository vocabularyBookRepository) {
        this.vocabularyBookRepository = vocabularyBookRepository;
    }

    public int score(Map<String, String> answers) {
        // 結果生成
        List<ClientAnswer> clientAnswerList = convertToClientAnswer(answers);
        Map<String, String> correctAnswerMap = correctAnswerMap(answers);

        // 永続化
        ExamResult result = new ExamResult("userId", clientAnswerList, correctAnswerMap);

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

    /**
     * <id, 正解>のMapを生成
     * */
    private Map<String, String> correctAnswerMap(Map<String, String> answers) {
        Map<String, String> correctAnswerMap = new HashMap<>();
        List<String> wordIdList = new ArrayList<>(answers.keySet());

        List<VocabularyBook> vBookList
                = (List<VocabularyBook>) vocabularyBookRepository.findAllById(wordIdList);
        for(VocabularyBook vBook : vBookList) {
            correctAnswerMap.put(vBook.getId(), vBook.getMeaning());
        }

        return correctAnswerMap;
    }
}
