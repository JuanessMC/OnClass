package com.pragma.bootcamp2024.adapters.driving.http.mapper;

import com.pragma.bootcamp2024.adapters.driving.http.dto.response.TechnologyResponse;
import com.pragma.bootcamp2024.domain.model.Technology;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITechnologyResponseMapper {

    TechnologyResponse toTechnologyResponse(Technology technology);
}
