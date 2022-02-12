package com.kugutsu.wordTest.domain.model.examResult;

import com.kugutsu.wordTest.dataSource.examResult.ExamResultDataSource;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamResultRepository  extends CrudRepository<ExamResultDataSource, String> {

    @Query("SELECT * FROM EXAM_RESULT WHERE USER_ID = :userId")
    public List<ExamResultDataSource> getExamResultByUserId(String userId);

}
