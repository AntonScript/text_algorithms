package com.example.text_algorithms.api;


import com.example.text_algorithms.api.dto.InformationTextRequest;
import com.example.text_algorithms.api.dto.InformationTextResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
import static javax.servlet.http.HttpServletResponse.SC_OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * API - для поиска кол-ва заданых слов в заданном тексте.
 *
 * @author Anton Mamakin
 */
@Api(tags = "text")
@RequestMapping(TextApi.PATH)
public interface TextApi {
    String PATH = "/api/rest/text";


    @ApiOperation(value = "Получить колличество слов, которые заданы для поиска",
                  notes = "Получить колличество слов, которые заданы для поиска",
                  response = InformationTextResponse.class,
                  responseContainer = "List",
                  tags = {"text"})
    @ApiResponses({
        @ApiResponse(code = SC_OK,
                     message = "Результат поиска слов в тексте",
                     response = InformationTextResponse.class, responseContainer = "List"),
        @ApiResponse(code = SC_INTERNAL_SERVER_ERROR,
                     message = "Внутренняя ошибка сервера при выполнении запроса")
    })
    @PostMapping(value = "/find/{searchType}",
                 consumes = APPLICATION_JSON_UTF8_VALUE,
                 produces = APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<List<InformationTextResponse>> getCountWords(
        @PathVariable("searchType") String searchType,
        @RequestBody InformationTextRequest request);

    @ApiOperation(
        value = "Получить список типов алгоритмов, полученные значения используются в качестве параметра searchType" +
            "метода /find/{searchType}",
        notes = "Получить колличество слов, которые заданы для поиска",
        response = String.class,
        tags = {"text"})
    @ApiResponses({
        @ApiResponse(code = SC_OK,
                     message = "Список типов алгоритмов поиска",
                     response = String.class, responseContainer = "List"),
        @ApiResponse(code = SC_INTERNAL_SERVER_ERROR,
                     message = "Внутренняя ошибка сервера при выполнении запроса")
    })
    @GetMapping(value = "/types",
                produces = APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<List<String>> getTypes();

}
