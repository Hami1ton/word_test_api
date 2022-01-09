package com.kugutsu.wordTest.presentation.controller;

import com.kugutsu.wordTest.application.service.exam.ExamService;
import com.kugutsu.wordTest.application.service.examResult.ExamResultService;
import com.kugutsu.wordTest.dataSource.examResult.ExamResultDataSource;
import com.kugutsu.wordTest.domain.model.exam.Mondai;
import com.kugutsu.wordTest.presentation.dto.request.ScoringRequest;
import com.kugutsu.wordTest.presentation.dto.response.ExamResultResponse;
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
