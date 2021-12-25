package com.kugutsu.wordTest.application.service.exam;

import com.kugutsu.wordTest.domain.model.vocabularyBook.VocabularyBook;
import com.kugutsu.wordTest.domain.model.problem.FiveProblems;
import com.kugutsu.wordTest.domain.model.problem.Problem;
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
    public List<Problem> takeExam() {
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
