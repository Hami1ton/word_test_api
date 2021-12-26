package com.kugutsu.wordTest.presentation.controller;

import com.kugutsu.wordTest.application.service.exam.ExamService;
import com.kugutsu.wordTest.domain.model.exam.Mondai;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExamController {

    private final ExamService service;

    public ExamController(ExamService service) {
        this.service = service;
    }

    @GetMapping(value = "/problems")
    public List<Mondai> takeExam() {
        List<Mondai> res = service.takeExam();
        return res;
    }
}
