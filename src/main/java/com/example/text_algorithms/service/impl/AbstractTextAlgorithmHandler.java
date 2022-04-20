package com.example.text_algorithms.service.impl;

import com.example.text_algorithms.domain.DataText;
import com.example.text_algorithms.domain.InformationText;
import com.example.text_algorithms.service.TextAlgorithmHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Содержит общие методы для всех алгоритмов
 *
 * @author Anton Mamakin
 **/
public abstract class AbstractTextAlgorithmHandler implements TextAlgorithmHandler {

    protected Map<String, Integer> countWords;

    protected Map<String, Integer> getPatter(DataText dataText) {
        countWords = new HashMap<>(dataText.getWords().size());
        dataText.getWords().forEach(s -> countWords.put(s, 0));
        return countWords;
    }

    protected List<InformationText> toInformationText(Map<String, Integer> map) {
        List<InformationText> result = new ArrayList<>(map.size());
        for (String key : map.keySet()) {
            result.add(new InformationText(key, map.get(key)));
        }
        result.sort((o1, o2) -> o2.getCount() - o1.getCount());

        return result;
    }

}
