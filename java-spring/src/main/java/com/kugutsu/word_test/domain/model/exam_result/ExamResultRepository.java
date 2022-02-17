package com.kugutsu.word_test.domain.model.exam_result;

import com.kugutsu.word_test.data_source.exam_result.ExamResultDataSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamResultRepository  extends JpaRepository<ExamResultDataSource, String> {

    @Query(value = "SELECT * FROM EXAM_RESULT WHERE USER_ID = :userId", nativeQuery = true)
    List<ExamResultDataSource> getExamResultByUserId(String userId);

}
