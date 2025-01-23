package com.autozen.userservice.dto.request;

import com.autozen.userservice.entity.enums.Role;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import static com.autozen.userservice.utils.MessageConstants.FIRST_NAME_LENGTH_MESSAGE;
import static com.autozen.userservice.utils.MessageConstants.FIRST_NAME_SPACES_MESSAGE;
import static com.autozen.userservice.utils.MessageConstants.LAST_NAME_LENGTH_MESSAGE;
import static com.autozen.userservice.utils.MessageConstants.LAST_NAME_SPACES_MESSAGE;
import static com.autozen.userservice.utils.MessageConstants.NAME_FORMAT_MESSAGE;
import static com.autozen.userservice.utils.MessageConstants.PHONE_VALIDATION_MESSAGE;
import static com.autozen.userservice.utils.RegexConstants.NAME_FORMAT_REGEX;
import static com.autozen.userservice.utils.RegexConstants.PHONE_REGEX;
import static com.autozen.userservice.utils.RegexConstants.SPACES_REGEX;

@Builder
public record UpdateUserRequestDto(
        @Size(min = 2, max = 30, message = FIRST_NAME_LENGTH_MESSAGE)
        @Pattern.List({
                @Pattern(regexp = SPACES_REGEX, message = FIRST_NAME_SPACES_MESSAGE),
                @Pattern(regexp = NAME_FORMAT_REGEX, message = NAME_FORMAT_MESSAGE)
        })
        String firstName,

        @Size(min = 2, max = 30, message = LAST_NAME_LENGTH_MESSAGE)
        @Pattern.List({
                @Pattern(regexp = SPACES_REGEX, message = LAST_NAME_SPACES_MESSAGE),
                @Pattern(regexp = NAME_FORMAT_REGEX, message = NAME_FORMAT_MESSAGE)
        })
        String lastName,

        @Pattern(regexp = PHONE_REGEX, message = PHONE_VALIDATION_MESSAGE)
        String phoneNumber,

        Role role
) {
}
