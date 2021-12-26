package com.kugutsu.wordTest.application.service.exam;

import com.kugutsu.wordTest.application.service.vocabularyBook.VocabularyBookRepository;
import com.kugutsu.wordTest.domain.model.exam.FlashCard;
import com.kugutsu.wordTest.domain.model.exam.FlashCardCollection;
import com.kugutsu.wordTest.domain.model.exam.Mondai;
import com.kugutsu.wordTest.domain.model.vocabularyBook.VocabularyBook;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class MondaiFactory {

    private static VocabularyBookRepository repository;

    public MondaiFactory(VocabularyBookRepository repository) {
        this.repository = repository;
    }

    public static Mondai createMondai() {
        List<VocabularyBook> VocabularyBookList = repository.get3VBooksEntity();
        List<FlashCard> flashCardList = VocabularyBookList.stream()
                .map(book -> convertVocabularyBookToFlashCard(book))
                .collect(Collectors.toList());

        FlashCardCollection flashCardCollection = new FlashCardCollection(flashCardList);
        return flashCardCollection.createMondai();
    }

    private static FlashCard convertVocabularyBookToFlashCard(VocabularyBook book) {
        FlashCard card = new FlashCard(book.getWord(), book.getMeaning());
        return card;
    }
}
