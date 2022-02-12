package com.kugutsu.wordTest.domain.model.vocabularyBook;

import com.kugutsu.wordTest.dataSource.vocabularyBook.VocabularyBook;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VocabularyBookRepository extends CrudRepository<VocabularyBook, String> {

    /*
     * 単語帳からタンダムに 指定数 個の単語を取得し、Entityクラスのリストとして返す
     *
     * */
    @Query("SELECT * FROM VOCABULARY_BOOK ORDER BY RAND() LIMIT :num")
    List<VocabularyBook> getSpecifiedNumberVBooks(int num);

    /*
     * 英単語IDで検索
     *
     * */
    @Query("SELECT * FROM VOCABULARY_BOOK WHERE ID = :eWordId")
    VocabularyBook getVBooksByWordId(String eWordId);

}
