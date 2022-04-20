package com.example.text_algorithms.domain;

import lombok.Data;

/**
 * Объект с результом поиска кол-ва слов в тексте.
 *
 * @author Anton Mamakin
 */
@Data
public class InformationText {

    public InformationText(String word, Integer count) {
        this.word = word;
        this.count = count;
    }

    /**
     * Искомое слово.
     */
    private String word;

    /**
     * Кол-во слов в тексте.
     */
    public Integer count;
}
