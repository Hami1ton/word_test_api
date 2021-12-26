package com.kugutsu.wordTest.application.service.exam;

import com.kugutsu.wordTest.domain.model.exam.Exam;
import com.kugutsu.wordTest.domain.model.exam.Mondai;
import com.kugutsu.wordTest.application.service.vocabularyBook.VocabularyBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExamService {

    private final VocabularyBookRepository vBookRepository;

    public ExamService(VocabularyBookRepository vBookRepository) {
        this.vBookRepository = vBookRepository;
    }

    /*
     * 問題のリストを作成する
     *
     * */
    public List<Mondai> takeExam() {
        Exam exam = ExamFactory.createExam();
        return exam.getMondaiList();
    }
}
