package com.kugutsu.word_test.domain.model.vocabulary_book;

import com.kugutsu.word_test.data_source.vocabulary_book.VocabularyBookDataSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VocabularyBookRepository extends JpaRepository<VocabularyBookDataSource, String> {

    /*
     * 単語帳からタンダムに 指定数 個の単語を取得し、Entityクラスのリストとして返す
     *
     * */
    @Query(value = "SELECT * FROM VOCABULARY_BOOK ORDER BY RAND() LIMIT :num", nativeQuery = true)
    List<VocabularyBookDataSource> getSpecifiedNumberVBooks(int num);

}
