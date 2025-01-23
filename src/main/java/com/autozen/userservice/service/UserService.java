package com.autozen.userservice.service;

import com.autozen.userservice.dto.request.RegisterUserRequestDto;
import com.autozen.userservice.dto.request.UpdateUserRequestDto;

import java.util.UUID;

public interface UserService {

    void registerUser(RegisterUserRequestDto registerUserRequestDto);

    void updateUser(UUID userId, UpdateUserRequestDto updateUserRequestDto);

    void deleteUser(UUID userId);


}
