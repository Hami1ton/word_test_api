package com.kugutsu.wordTest.application.service.examResult;

import com.kugutsu.wordTest.dataSource.examResult.ExamResultDataSource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamResultRepository  extends CrudRepository<ExamResultDataSource, String> {

}
