package com.kugutsu.wordTest.application.service.exam;


import com.kugutsu.wordTest.domain.model.exam.Exam;
import com.kugutsu.wordTest.domain.model.exam.Mondai;

import java.util.ArrayList;
import java.util.List;

public class ExamFactory {

    private static int numberOfMondai = 5;

    public static Exam createExam() {

        List<Mondai> mondaiList = new ArrayList<>();

        for(int i = 0; i < numberOfMondai; i++) {
            mondaiList.add(MondaiFactory.createMondai());
        }

        return new Exam(mondaiList);
    }
}
