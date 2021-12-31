package com.kugutsu.wordTest.application.service.examResult;

import com.kugutsu.wordTest.domain.model.examResult.ExamResult;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamResultRepository {

    /*
     * 試験結果を新規追加
     * */
    @Query("SELECT * FROM VOCABULARY_BOOK ORDER BY RAND() LIMIT :num")
    void addResult(ExamResult examResult);

}
