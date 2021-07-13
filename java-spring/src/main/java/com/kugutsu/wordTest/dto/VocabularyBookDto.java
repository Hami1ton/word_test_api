package com.kugutsu.wordTest.dto;

import com.kugutsu.wordTest.entity.VocabularyBook;
import lombok.Data;

@Data
public class VocabularyBookDto {

    private String id;

    private String word;

    private String meaning;

    public VocabularyBookDto(String id, String word, String meaning) {
        this.id = id;
        this.word = word;
        this.meaning = meaning;
    }


    public static VocabularyBookDto newVocabularyBookDto(VocabularyBook vocabularyBook) {
        return new VocabularyBookDto(vocabularyBook.getId(), vocabularyBook.getWord(), vocabularyBook.getMeaning());
    }

}
