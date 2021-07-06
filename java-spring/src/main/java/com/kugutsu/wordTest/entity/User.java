package com.kugutsu.wordTest.entity;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    private String userId;

    private String pass;

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return pass;
    }
}
