package com.autozen.userservice.dto.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorDetailDto(
        String field,
        String message
) {
}