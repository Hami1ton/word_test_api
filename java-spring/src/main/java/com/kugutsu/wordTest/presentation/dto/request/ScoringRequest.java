package com.kugutsu.wordTest.presentation.dto.request;

import lombok.Data;

import java.util.Map;

@Data
public class ScoringRequest {

    /* <wordId, 選択した意味> のMap */
    private Map<String, String> answers;

}
