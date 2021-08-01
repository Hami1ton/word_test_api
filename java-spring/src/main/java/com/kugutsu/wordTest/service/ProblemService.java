package com.kugutsu.wordTest.service;

import com.kugutsu.wordTest.model.Problem;
import com.kugutsu.wordTest.entity.VocabularyBook;
import com.kugutsu.wordTest.repository.VocabularyBookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProblemService {

    private final VocabularyBookRepository vBookRepository;

    public ProblemService(VocabularyBookRepository vBookRepository) {
        this.vBookRepository = vBookRepository;
    }


    /*
     * 問題のリスト(要素数5)を作成する
     *
     * */
    public List<Problem> makeProblems() {
        // 単語帳からタンダムに15個の単語を取得する
        List<VocabularyBook> vBooksOf15 = get15VBooks();

        // 15個の単語から、問題にする単語を5個選ぶ
        List<VocabularyBook> problemVBooks = vBooksOf15.subList(0, 5);
        // 残りはブラフの選択肢用の単語
        List<VocabularyBook> bluffVBooks = vBooksOf15.subList(5, 15);

        // 5問題を作成する
        List<Problem> res = makeProblemsByVBooks(problemVBooks, bluffVBooks);
        return res;
    }

    /*
     * 与えられた単語帳から、5個の問題からなるリストを作成する
     *
     * */
    private List<Problem> makeProblemsByVBooks(List<VocabularyBook> problemVBooks, List<VocabularyBook> bluffVBooks) {
        List<Problem> problems = new ArrayList<>();

        int bluffVBooksCount = 0;

        for (VocabularyBook book : problemVBooks) {
            String bluff1 = bluffVBooks.get(bluffVBooksCount).getMeaning();
            String bluff2 = bluffVBooks.get(bluffVBooksCount + 1).getMeaning();
            // 問題を作成
            Problem problem = Problem.createNewProblem(book.getId(), book.getWord(), book.getMeaning(), bluff1, bluff2);
            bluffVBooksCount += 2;
            problems.add(problem);
        }

        return problems;
    }

    /*
     * 単語帳からランダムに15個の単語を取得する
     *
     * */
    private List<VocabularyBook> get15VBooks() {
        // 15個の単語を取得する
        List<VocabularyBook> vBooks = vBookRepository.get15VBooksEntity();
        return vBooks;
    }

}
