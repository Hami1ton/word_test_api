package com.kugutsu.wordTest.application.service.exam;


import com.kugutsu.wordTest.domain.model.exam.Exam;


public class ExamFactory {

    public static Exam createExam() {
        return new Exam(MondaiListFactory.createMondaiList());
    }
}
