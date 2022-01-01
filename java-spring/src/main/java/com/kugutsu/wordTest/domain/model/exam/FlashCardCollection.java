package com.kugutsu.wordTest.domain.model.exam;


import java.util.List;
import java.util.Random;


public class FlashCardCollection {

    private List<FlashCard> flashCardList;

    public FlashCardCollection(List<FlashCard> flashCardList){
        this.flashCardList = flashCardList;
        
    }

    public Mondai createMondai() {
        String id = flashCardList.get(0).getId();
        String word = flashCardList.get(0).getWord();
        String meaning = flashCardList.get(0).getMeaning();
        String bluff1 = flashCardList.get(1).getMeaning();
        String bluff2 = flashCardList.get(2).getMeaning();

        String choice1;
        String choice2;
        String choice3;
        // 選択肢の配置にランダム性を持たせるための処理
        Random rand = new Random();
        int num = rand.nextInt(3);
        if (num == 0) {
            choice1 = meaning;
            choice2 = bluff1;
            choice3 = bluff2;
        } else if (num == 1) {
            choice1 = bluff2;
            choice2 = meaning;
            choice3 = bluff1;
        } else {
            choice1 = bluff1;
            choice2 = bluff2;
            choice3 = meaning;
        }

        return new Mondai(id, word, choice1, choice2, choice3);
    }
}
