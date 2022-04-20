package com.example.text_algorithms.service.impl;

import com.example.text_algorithms.domain.DataText;
import com.example.text_algorithms.domain.InformationText;
import com.example.text_algorithms.service.TextAlgorithmHandler;
import com.example.text_algorithms.service.TextService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Anton Mamakin
 **/
@Service
@NoArgsConstructor
public class TextServiceImpl implements TextService {

    private Map<String, TextAlgorithmHandler> handlersMap;

    private List<String> types;

    @Autowired
    public TextServiceImpl(List<TextAlgorithmHandler> handlers) {
        handlersMap = new HashMap<>(handlers.size());
        types =  new ArrayList<>();
        for (TextAlgorithmHandler algorithmHandler: handlers) {
            handlersMap.put(algorithmHandler.getIdentifiers(), algorithmHandler);
            types.add(algorithmHandler.getIdentifiers());
        }
    }

    @Override
    public List<InformationText> getCountWords(String searchType, DataText dataText) {
        if(!handlersMap.containsKey(searchType)) {
            throw new RuntimeException();
        }

        return handlersMap.get(searchType).getCountWords(dataText);
    }

    @Override
    public List<String> getTypes() {
        return types;
    }
}
