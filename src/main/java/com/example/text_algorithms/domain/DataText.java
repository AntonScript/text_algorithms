package com.example.text_algorithms.domain;

import lombok.Data;
import java.util.List;

/**
 * Объект для поиска кол-ва заданных слов в тексте.
 *
 * @author Anton Mamakin
 */
@Data
public class DataText {

    /**
     * Список слов для поиска.
     */
    private List<String> words;

    /**
     * Текст поиска.
     */
    public String text;
}
