package com.kugutsu.wordTest.service;

import com.kugutsu.wordTest.dto.VocabularyBookDto;
import com.kugutsu.wordTest.repository.VocabularyBookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProblemService {

    private final VocabularyBookRepository vBookRepository;


    public ProblemService(VocabularyBookRepository vBookRepository) {
        this.vBookRepository = vBookRepository;
    }

    public List<VocabularyBookDto> findAll() {
        List<VocabularyBookDto> VocabularyBookDtoList = new ArrayList<>();
        vBookRepository.findAll().iterator()
                .forEachRemaining(book -> VocabularyBookDtoList.add(VocabularyBookDto.newVocabularyBookDto(book)));
        return VocabularyBookDtoList;
    }

}
