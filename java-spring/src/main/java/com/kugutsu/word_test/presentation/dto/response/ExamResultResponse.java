package com.kugutsu.word_test.presentation.dto.response;

import com.kugutsu.word_test.data_source.exam_result.ExamResultDataSource;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ExamResultResponse {

    private List<ExamResultResponseDto> examResultResponseDtoList;

    public ExamResultResponse(List<ExamResultDataSource> examResultDataSourceList) {
        this.examResultResponseDtoList
                = examResultDataSourceList.stream()
                .map(examResult -> new ExamResultResponseDto(examResult.getId(), examResult.getUserId(), examResult.getScore()))
                .collect(Collectors.toList());
    }
}

@Data
class ExamResultResponseDto {

    private String id;

    private String userId;

    private int score;

    public ExamResultResponseDto(String id, String userId, int score) {
        this.id = id;
        this.userId = userId;
        this.score = score;
    }

}
