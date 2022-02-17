package com.kugutsu.word_test.application.service.exam;

import com.kugutsu.word_test.domain.model.exam.Exam;
import com.kugutsu.word_test.domain.model.exam.Mondai;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExamService {

    /*
     * 問題のリストを作成する
     *
     * */
    public List<Mondai> takeExam() {
        Exam exam = ExamFactory.createExam();
        return exam.getMondaiList();
    }
}
