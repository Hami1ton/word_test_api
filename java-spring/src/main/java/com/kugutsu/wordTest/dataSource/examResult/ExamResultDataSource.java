package com.kugutsu.wordTest.dataSource.examResult;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

/**
 * 試験結果(永続化用)
 */
@Table("EXAM_RESULT")
public class ExamResultDataSource implements Persistable<String> {

    @Id
    private String id;

    private String userId;

    private final int score;

    public ExamResultDataSource(String id, String userId, int score) {
        this.id = id;
        this.userId = userId;
        this.score = score;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return true;
    }
}
