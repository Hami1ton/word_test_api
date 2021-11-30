package com.kugutsu.wordTest.application.service;

import com.kugutsu.wordTest.domain.model.FiveProblems;
import com.kugutsu.wordTest.domain.model.Problem;
import com.kugutsu.wordTest.domain.model.VocabularyBook;
import com.kugutsu.wordTest.domain.repository.VocabularyBookRepository;
import org.springframework.stereotype.Service;
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
        List<VocabularyBook> vBooksOf15 = vBookRepository.get15VBooksEntity();

        // 15個の単語から、問題にする単語を5個選ぶ
        List<VocabularyBook> problemVBooks = vBooksOf15.subList(0, 5);
        // 残りはブラフの選択肢用の単語
        List<VocabularyBook> bluffVBooks = vBooksOf15.subList(5, 15);

        // 5問題を作成する
        FiveProblems problems = FiveProblems.makeProblemsByVBooks(problemVBooks, bluffVBooks);

        return problems.getList();
    }

}
