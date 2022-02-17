package com.kugutsu.word_test.presentation.dto.request;

import lombok.Data;

import java.util.Map;

@Data
public class ScoringRequest {

    private String userId;

    /* <wordId, 選択した意味> のMap */
    private Map<String, String> answers;

}
