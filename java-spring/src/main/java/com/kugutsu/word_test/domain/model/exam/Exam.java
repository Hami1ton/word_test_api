package com.kugutsu.word_test.domain.model.exam;

import java.util.Collections;
import java.util.List;

/**
 * 試験
 */
public class Exam {

    List<Mondai> mondaiList;

    public Exam(List<Mondai> mondaiList) {
        this.mondaiList = mondaiList;
    }

    public List<Mondai> getMondaiList() {
        return Collections.unmodifiableList(mondaiList);
    }

    @Override
    public String toString() {
        return "Exam{" +
                "問題=" + mondaiList +
                '}';
    }

}
