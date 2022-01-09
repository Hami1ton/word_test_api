package com.kugutsu.wordTest.application.service.exam;

import com.kugutsu.wordTest.domain.model.exam.Exam;
import com.kugutsu.wordTest.domain.model.exam.Mondai;
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
