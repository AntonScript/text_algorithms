package com.example.text_algorithms.service;

import com.example.text_algorithms.domain.DataText;
import com.example.text_algorithms.domain.InformationText;
import java.util.List;

/**
 * Сервис для работы с текстом.
 *
 * @author Anton Mamakin
 **/
public interface TextService {

    /**
     * Получить кол-во слов в тексте для заданных слов
     *
     * @param searchType - типа алгоритма
     * @param dataText - информация для поиска
     *
     * @return информация о кол-ве слов в тексте
     **/
    List<InformationText> getCountWords(String searchType, DataText dataText);

    /**
     * Получить типы алгоритмов
     *
     * @return типы алгоритмов
     **/
    List<String> getTypes();
}
