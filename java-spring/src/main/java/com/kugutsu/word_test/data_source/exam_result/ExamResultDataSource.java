package com.kugutsu.word_test.data_source.exam_result;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 試験結果(永続化用)
 */
@Entity
@Getter
@Table(name = "EXAM_RESULT")
@NoArgsConstructor
public class ExamResultDataSource{

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "SCORE")
    private int score;

    public ExamResultDataSource(String id, String userId, int score) {
        this.id = id;
        this.userId = userId;
        this.score = score;
    }
}
