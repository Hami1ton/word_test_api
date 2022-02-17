package com.kugutsu.word_test.application.service.exam;


import com.kugutsu.word_test.domain.model.exam.Exam;


public class ExamFactory {

    public static Exam createExam() {
        return new Exam(MondaiListFactory.createMondaiList());
    }
}
