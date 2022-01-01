package com.kugutsu.wordTest.domain.model.exam;


import lombok.Getter;

/**
 * 単語と意味のセット
 */
@Getter
public class FlashCard {

    private String id;

    private String word;

    private String meaning;

    public FlashCard(String id, String word, String meaning){
        this.id = id;
        this.word = word;
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return "Mondai{" +
                "id=" + id + "," +
                "英単語=" + word + "," +
                "意味" + meaning +
                '}';
    }

}
