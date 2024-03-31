package com.pragma.bootcamp2024.adapters.driving.http.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.pragma.bootcamp2024.domain.util.DomainConstants;

public record AddTechnologyRequest(
        @NotBlank(message = DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE)
        @Size(min = 2, max = 50, message = DomainConstants.FIELD_NAME_SIZE_MESSAGE)
        String name,
        @NotBlank(message = DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE)
        @Size(min = 2, max = 90, message = DomainConstants.FIELD_DESCRIPTION_SIZE_MESSAGE)
        String description) {
}

