package com.kugutsu.word_test.application.service.exam;

import com.kugutsu.word_test.domain.model.vocabulary_book.VocabularyBookRepository;
import com.kugutsu.word_test.domain.model.exam.FlashCard;
import com.kugutsu.word_test.domain.model.exam.FlashCardCollection;
import com.kugutsu.word_test.domain.model.exam.Mondai;
import com.kugutsu.word_test.data_source.vocabulary_book.VocabularyBookDataSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MondaiListFactory {

    private static final int numberOfMondai = 5;

    private static VocabularyBookRepository repository;

    public MondaiListFactory(VocabularyBookRepository repository) {
        this.repository = repository;
    }

    public static List<Mondai> createMondaiList() {
        List<VocabularyBookDataSource> vocabularyBookDataSourceList = repository.getSpecifiedNumberVBooks(numberOfMondai * 3);
        List<FlashCard> flashCardList = vocabularyBookDataSourceList.stream()
                .map(book -> convertVocabularyBookToFlashCard(book))
                .collect(Collectors.toList());

        List<FlashCardCollection> collectionList
                = createFlashCardCollectionList(flashCardList);

        return collectionList.stream()
                .map(collection -> collection.createMondai())
                .collect(Collectors.toList());
    }

    private static FlashCard convertVocabularyBookToFlashCard(VocabularyBookDataSource book) {
        FlashCard card = new FlashCard(book.getId(), book.getWord(), book.getMeaning());
        return card;
    }

    /*
     * 問題数の要素をもつFlashCardCollectionのListを作成する
     * */
    private static List<FlashCardCollection> createFlashCardCollectionList(List<FlashCard> flashCardList) {
        List<FlashCardCollection> flashCardCollectionList = new ArrayList<>();
        int max =  numberOfMondai * 3;

        for(int i = 0; i < max; i = i + 3) {
            FlashCardCollection collection = new FlashCardCollection(flashCardList.subList(i, i+3));
            flashCardCollectionList.add(collection);
        }

        return flashCardCollectionList;
    }
}
