package com.kugutsu.word_test.presentation.dto.request;

import lombok.Data;

@Data
public class UserLoginRequest {

    private String userId;

    private String password;

}
