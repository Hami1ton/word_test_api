package com.kugutsu.wordTest.controller;

import com.kugutsu.wordTest.model.Problem;
import com.kugutsu.wordTest.service.ProblemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ProblemController {

    private final ProblemService service;

    public ProblemController(ProblemService service) {
        this.service = service;
    }

    @GetMapping(value = "/problems")
    public List<Problem> problems() {
        List<Problem> res = service.makeProblems();
        return res;
    }
}
