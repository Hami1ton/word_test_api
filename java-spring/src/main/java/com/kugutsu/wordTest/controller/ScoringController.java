package com.kugutsu.wordTest.controller;

import com.kugutsu.wordTest.dto.request.ScoringRequest;
import com.kugutsu.wordTest.service.ScoringService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ScoringController {

    private final ScoringService service;

    public ScoringController(ScoringService service) { this.service = service; };

    @RequestMapping(value = "/score", method = RequestMethod.POST)
    public int score(@RequestBody ScoringRequest request) {

        return service.calculateScore(request.getAnswers());
    }

}

