package com.example.text_algorithms.service.impl;

import com.example.text_algorithms.domain.DataText;
import com.example.text_algorithms.domain.InformationText;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * @author Anton Mamakin
 **/
@Service
public class TextAlgorithmHandlerPrimitive extends AbstractTextAlgorithmHandler {

    @Override
    public List<InformationText> getCountWords(DataText dataText) {
        countWords = getPatter(dataText);
        algorithm(countWords, dataText.getText().trim());
        return toInformationText(countWords);
    }

    private void algorithm(Map<String, Integer> countWords, String text) {
        String[] preResult = text.split("\\s");
        for (String s : preResult) {
            if (countWords.containsKey(s)) {
                countWords.put(s, countWords.get(s) + 1);
            }
        }
    }

    @Override
    public String getIdentifiers() {
        return "primitive";
    }
}
