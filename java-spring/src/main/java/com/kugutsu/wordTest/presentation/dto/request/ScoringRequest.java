package com.kugutsu.wordTest.presentation.dto.request;

import lombok.Data;

import java.util.Map;

@Data
public class ScoringRequest {

    private Map<String, String> answers;

}