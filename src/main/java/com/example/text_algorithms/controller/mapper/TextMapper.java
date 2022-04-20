package com.example.text_algorithms.controller.mapper;

import com.example.text_algorithms.api.dto.InformationTextRequest;
import com.example.text_algorithms.api.dto.InformationTextResponse;
import com.example.text_algorithms.domain.DataText;
import com.example.text_algorithms.domain.InformationText;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import java.util.List;

/**
 * Маппер объектов.
 *
 * @author Anton Mamakin
 **/
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TextMapper {

    DataText toDomain(InformationTextRequest request);

    List<InformationTextResponse> toDto(List<InformationText> texts);

}
