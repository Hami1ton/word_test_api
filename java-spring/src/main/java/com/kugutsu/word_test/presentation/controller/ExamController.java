package com.kugutsu.word_test.presentation.controller;

import com.kugutsu.word_test.application.service.exam.ExamService;
import com.kugutsu.word_test.application.service.exam_result.ExamResultService;
import com.kugutsu.word_test.data_source.exam_result.ExamResultDataSource;
import com.kugutsu.word_test.domain.model.exam.Mondai;
import com.kugutsu.word_test.presentation.dto.request.ScoringRequest;
import com.kugutsu.word_test.presentation.dto.response.ExamResultResponse;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ExamController {

    private final ExamService examService;

    private final ExamResultService examResultService;

    public ExamController(ExamService examService, ExamResultService examResultService) {
        this.examService = examService;
        this.examResultService = examResultService;
    }

    @GetMapping(value = "/takeExam")
    public List<Mondai> takeExam() {
        List<Mondai> res = examService.takeExam();
        return res;
    }

    @RequestMapping(value = "/scoreExam", method = RequestMethod.POST)
    public int scoreExam(@RequestBody ScoringRequest request) {
        return examResultService.score(request.getUserId(), request.getAnswers());
    }

    @GetMapping(value = "/examResult")
    public ExamResultResponse examResult(@RequestParam String userId) {
        List<ExamResultDataSource> examResultDataSourceList = examResultService.examResult(userId);

        return new ExamResultResponse(examResultDataSourceList);
    }

}
