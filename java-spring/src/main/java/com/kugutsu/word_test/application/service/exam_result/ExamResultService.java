package com.kugutsu.word_test.application.service.exam_result;

import com.kugutsu.word_test.domain.model.exam_result.ExamResultRepository;
import com.kugutsu.word_test.domain.model.vocabulary_book.VocabularyBookRepository;
import com.kugutsu.word_test.data_source.exam_result.ExamResultDataSource;
import com.kugutsu.word_test.domain.model.exam_result.ClientAnswer;
import com.kugutsu.word_test.domain.model.exam_result.ExamResult;
import com.kugutsu.word_test.data_source.vocabulary_book.VocabularyBookDataSource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class ExamResultService {

    VocabularyBookRepository vocabularyBookRepository;

    ExamResultRepository examResultRepository;

    public int score(String userID, Map<String, String> answers) {
        // 結果生成
        List<ClientAnswer> clientAnswerList = convertToClientAnswer(answers);
        Map<String, String> correctAnswerMap = correctAnswerMap(answers);

        // 永続化
        ExamResult result = new ExamResult(userID, clientAnswerList, correctAnswerMap);
        saveExamResult(result);

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

        List<VocabularyBookDataSource> vBookList
                = vocabularyBookRepository.findAllById(wordIdList);
        for(VocabularyBookDataSource vBook : vBookList) {
            correctAnswerMap.put(vBook.getId(), vBook.getMeaning());
        }

        return correctAnswerMap;
    }

    @Transactional
    private void saveExamResult(ExamResult result) {
        ExamResultDataSource examResultDataSource
                = convertToExamResultDataSource(result);
        examResultRepository.save(examResultDataSource);
    }

    private ExamResultDataSource convertToExamResultDataSource(ExamResult examResult) {
        return new ExamResultDataSource(examResult.getId(), examResult.getUserId(), examResult.getScore());
    }

    public List<ExamResultDataSource> examResult(String userId) {
        return examResultRepository.getExamResultByUserId(userId);
    }
}
