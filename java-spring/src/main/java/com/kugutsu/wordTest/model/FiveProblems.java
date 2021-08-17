package com.kugutsu.wordTest.model;

import com.kugutsu.wordTest.entity.VocabularyBook;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class FiveProblems {

    List<Problem> fiveProblems;


    /*
     * 与えられた単語帳から、5個の問題からなるリストを作成する
     *
     * */
    public static FiveProblems makeProblemsByVBooks(List<VocabularyBook> problemVBooks, List<VocabularyBook> bluffVBooks) {
        List<Problem> problemList = new ArrayList<>();

        int bluffVBooksCount = 0;

        for (VocabularyBook book : problemVBooks) {
            String bluff1 = bluffVBooks.get(bluffVBooksCount).getMeaning();
            String bluff2 = bluffVBooks.get(bluffVBooksCount + 1).getMeaning();
            // 問題を作成
            Problem problem = Problem.createNewProblem(book.getId(), book.getWord(), book.getMeaning(), bluff1, bluff2);
            bluffVBooksCount += 2;
            problemList.add(problem);
        }

        return new FiveProblems(problemList);
    }

    public List<Problem> getList() {
        return Collections.unmodifiableList(fiveProblems);
    }
}
