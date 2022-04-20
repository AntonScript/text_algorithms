package com.example.text_algorithms.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Дто с результом поиска кол-ва слов в тексте.
 *
 * @author Anton Mamakin
 */
@ApiModel(description = "Дто с результом поиска кол-ва слов в тексте")
@Data
public class InformationTextResponse {


    /**
     * Искомое слово.
     */
    @ApiModelProperty("Искомое слово")
    private String word;

    /**
     * Кол-во слов в тексте.
     */
    @ApiModelProperty("Кол-во слов в тексте")
    public Integer count;
}
