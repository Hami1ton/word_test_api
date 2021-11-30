package com.kugutsu.wordTest.presentation.controller;

import com.kugutsu.wordTest.presentation.dto.request.UserLoginRequest;
import com.kugutsu.wordTest.presentation.dto.response.UserLoginResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserLoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserLoginResponse login(@RequestBody UserLoginRequest request) {

        UserLoginResponse res = new UserLoginResponse();
        res.setResult("success");

        return res;
    }

}
