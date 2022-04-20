package com.example.text_algorithms.service;

import com.example.text_algorithms.domain.DataText;
import com.example.text_algorithms.domain.InformationText;
import java.util.List;

/**
 * Сервис реализующий алгоритм поиска информации в тексте.
 *
 * @author Anton Mamakin
 **/
public interface TextAlgorithmHandler {

    /**
     * Получить кол-во слов в тексте для заданных слов
     *
     * @param dataText - информация для поиска
     *
     * @return информация о кол-ве слов в тексте
     **/
    List<InformationText> getCountWords(DataText dataText);

    /**
     * Получить тип алгоритма
     *
     * @return тип алгоритма
     **/
    String getIdentifiers();
}
