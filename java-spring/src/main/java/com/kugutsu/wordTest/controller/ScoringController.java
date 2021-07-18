package com.kugutsu.wordTest.controller;

import com.kugutsu.wordTest.dto.request.UserLoginRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoringController {

    @RequestMapping(value = "/score", method = RequestMethod.POST)
    public String score(@RequestBody UserLoginRequest request) {

        return null;
    }

}

