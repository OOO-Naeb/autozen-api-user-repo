package com.autozen.userservice.dto.error;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record ErrorDto(
        LocalDateTime timestamp,
        int status,
        List<ErrorDetailDto> errors
) {
}
