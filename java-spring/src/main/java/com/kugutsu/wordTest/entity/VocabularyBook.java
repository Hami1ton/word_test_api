package com.kugutsu.wordTest.entity;

import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class VocabularyBook {

    @Id
    private String id;

    private String word;

    private String meaning;
}
