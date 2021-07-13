package com.kugutsu.wordTest.repository;

import com.kugutsu.wordTest.entity.VocabularyBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VocabularyBookRepository extends CrudRepository<VocabularyBook, Integer> {

}
