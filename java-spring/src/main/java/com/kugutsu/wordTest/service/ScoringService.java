package com.kugutsu.wordTest.service;

import com.kugutsu.wordTest.repository.VocabularyBookRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ScoringService {

    private final VocabularyBookRepository repository;

    public ScoringService(VocabularyBookRepository repository) {
        this.repository = repository;
    }

    public int calculateScore(Map<String, String> answers) {

        int result = 0;

        for (String eWordId : answers.keySet()) {
            String answer = answers.get(eWordId);
            result += validateAnswer(eWordId, answer);
        }

        return result;
    }

    private int validateAnswer(String eWordId, String answer) {
        String correctAnswer = repository.getVBooksByWordId(eWordId).getMeaning();

        if (answer.equals(correctAnswer)) {
            return 1;
        }
        return 0;
    }
}
