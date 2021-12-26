package com.kugutsu.wordTest.domain.model.exam;


import lombok.Getter;

/**
 * 単語と意味のセット
 */
@Getter
public class FlashCard {

    private String word;

    private String meaning;

    public FlashCard(String word, String meaning){
        this.word = word;
        this.meaning = meaning;
    }

}
