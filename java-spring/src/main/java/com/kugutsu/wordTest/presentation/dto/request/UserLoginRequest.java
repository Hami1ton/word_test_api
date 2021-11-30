package com.kugutsu.wordTest.presentation.dto.request;

import lombok.Data;

@Data
public class UserLoginRequest {

    private String userId;

    private String password;

}
