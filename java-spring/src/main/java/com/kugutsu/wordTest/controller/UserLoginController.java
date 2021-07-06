package com.kugutsu.wordTest.controller;

import com.kugutsu.wordTest.dto.request.UserLoginRequest;
import com.kugutsu.wordTest.dto.response.UserLoginResponse;
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
