package com.kugutsu.word_test.data_source.vocabulary_book;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "VOCABULARY_BOOK")
public class VocabularyBookDataSource {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "WORD")
    private String word;

    @Column(name = "MEANING")
    private String meaning;
}
