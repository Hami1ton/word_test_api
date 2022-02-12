package com.kugutsu.wordTest.domain.model.examResult;

import com.kugutsu.wordTest.dataSource.examResult.ExamResultDataSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamResultRepository  extends JpaRepository<ExamResultDataSource, String> {

    @Query(value = "SELECT * FROM EXAM_RESULT WHERE USER_ID = :userId", nativeQuery = true)
    public List<ExamResultDataSource> getExamResultByUserId(String userId);

}
