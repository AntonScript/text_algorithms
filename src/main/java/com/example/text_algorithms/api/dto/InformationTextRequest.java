package com.example.text_algorithms.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.List;

/**
 * Дто для поиска кол-ва заданных слов в тексте.
 *
 * @author Anton Mamakin
 */
@ApiModel(description = "Дто для поиска кол-ва заданных слов в тексте")
@Data
public class InformationTextRequest {

    /**
     * Список слов для поиска.
     */
    @ApiModelProperty("Список слов для поиска")
    private List<String> words;

    /**
     * Текст поиска.
     */
    @ApiModelProperty("Текст поиска")
    public String text;
}
