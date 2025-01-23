package com.autozen.userservice.controller;

import com.autozen.userservice.dto.request.RegisterUserRequestDto;
import com.autozen.userservice.dto.request.UpdateUserRequestDto;
import com.autozen.userservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Tag(name = "User management")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(CREATED)
    @Operation(description = "Registers user in application")
    @ApiResponse(responseCode = "201", description = "Returns 201 after successful registration")
    public void registerUser(@RequestBody @Valid RegisterUserRequestDto registerUserRequestDto) {
        userService.registerUser(registerUserRequestDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    @Operation(description = "Updates user")
    @ApiResponse(responseCode = "204", description = "Returns 204 after successful update")
    public void updateUser(@PathVariable UUID id, @RequestBody @Valid UpdateUserRequestDto updateUserRequestDto) {
        userService.updateUser(id, updateUserRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    @Operation(description = "Deletes user")
    @ApiResponse(responseCode = "204", description = "Returns 204 after successful deletion")
    public void deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
    }
}
