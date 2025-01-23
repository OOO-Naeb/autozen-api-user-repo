package com.autozen.userservice.exception;

import com.autozen.userservice.dto.error.ErrorDetailDto;
import com.autozen.userservice.dto.error.ErrorDto;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseBody
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            @NonNull HttpHeaders headers, HttpStatusCode status,
            @NonNull WebRequest request
    ) {
        List<ErrorDetailDto> errors = ex.getBindingResult().getAllErrors().stream()
                .map(this::getErrorDetail)
                .toList();

        ErrorDto errorDto = getErrorDto(errors, status.value());

        return new ResponseEntity<>(errorDto, headers, status.value());
    }

    @ExceptionHandler(RegistrationException.class)
    public ResponseEntity<?> handleRegistrationException(RegistrationException ex) {
        return getResponseEntity(BAD_REQUEST, ex);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<?> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        return getResponseEntity(CONFLICT, ex);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException ex) {
        return getResponseEntity(NOT_FOUND, ex);
    }

    @ExceptionHandler(UserUpdateException.class)
    public ResponseEntity<?> handleUserUpdateException(UserUpdateException ex) {
        return getResponseEntity(BAD_REQUEST, ex);
    }

    @ExceptionHandler(UserDeletionException.class)
    public ResponseEntity<?> handleUserDeletionException(UserDeletionException ex) {
        return getResponseEntity(BAD_REQUEST, ex);
    }

    @NotNull
    private ResponseEntity<?> getResponseEntity(HttpStatus httpStatus, Exception e) {
        List<ErrorDetailDto> errors = List.of(ErrorDetailDto.builder()
                .message(e.getMessage())
                .build());

        ErrorDto errorDto = getErrorDto(errors, httpStatus.value());

        return new ResponseEntity<>(errorDto, httpStatus);
    }

    private ErrorDto getErrorDto(List<ErrorDetailDto> errors, int status) {
        return ErrorDto.builder()
                .timestamp(LocalDateTime.now())
                .status(status)
                .errors(errors)
                .build();
    }

    private ErrorDetailDto getErrorDetail(ObjectError objectError) {
        if (objectError instanceof FieldError fieldError) {
            return ErrorDetailDto.builder()
                    .field(fieldError.getField())
                    .message(fieldError.getDefaultMessage())
                    .build();
        }
        return ErrorDetailDto.builder()
                .message(objectError.getDefaultMessage())
                .build();
    }
}
