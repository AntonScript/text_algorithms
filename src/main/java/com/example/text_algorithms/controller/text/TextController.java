package com.example.text_algorithms.controller.text;

import com.example.text_algorithms.api.TextApi;
import com.example.text_algorithms.api.dto.InformationTextRequest;
import com.example.text_algorithms.api.dto.InformationTextResponse;
import com.example.text_algorithms.controller.mapper.TextMapper;
import com.example.text_algorithms.service.TextService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author Anton Mamakin
 */
@RestController
@RequiredArgsConstructor
public class TextController implements TextApi {

    private final TextService service;

    private final TextMapper mapper;

    @Override
    public ResponseEntity<List<InformationTextResponse>> getCountWords(
        @PathVariable("searchType") String searchType,
        @RequestBody InformationTextRequest request) {
        return ResponseEntity.ok(mapper.toDto(service.getCountWords(searchType, mapper.toDomain(request))));
    }

    @Override
    public ResponseEntity<List<String>> getTypes() {
        return ResponseEntity.ok(service.getTypes());
    }
}
