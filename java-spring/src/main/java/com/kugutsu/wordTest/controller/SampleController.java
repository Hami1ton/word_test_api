package com.kugutsu.wordTest.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {

    @CrossOrigin
    @RequestMapping(value = "/sample", method = RequestMethod.POST)
    public String samplePost(@RequestBody String userId, String pass) {
        System.out.println(userId);

        return "Hello";
    }
}
