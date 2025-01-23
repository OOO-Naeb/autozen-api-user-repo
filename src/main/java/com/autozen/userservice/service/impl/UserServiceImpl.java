package com.autozen.userservice.service.impl;

import com.autozen.userservice.dto.request.RegisterUserRequestDto;
import com.autozen.userservice.dto.request.UpdateUserRequestDto;
import com.autozen.userservice.entity.User;
import com.autozen.userservice.exception.RegistrationException;
import com.autozen.userservice.exception.UserAlreadyExistsException;
import com.autozen.userservice.exception.UserDeletionException;
import com.autozen.userservice.exception.UserNotFoundException;
import com.autozen.userservice.exception.UserUpdateException;
import com.autozen.userservice.mapper.UserMapper;
import com.autozen.userservice.repository.UserRepository;
import com.autozen.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.autozen.userservice.utils.MessageConstants.FAILED_TO_DELETE_USER;
import static com.autozen.userservice.utils.MessageConstants.FAILED_TO_REGISTER_USER;
import static com.autozen.userservice.utils.MessageConstants.FAILED_TO_UPDATE_USER;
import static com.autozen.userservice.utils.MessageConstants.USER_ALREADY_EXISTS_MESSAGE;
import static com.autozen.userservice.utils.MessageConstants.USER_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;


    @Override
    public void registerUser(RegisterUserRequestDto registerUserRequestDto) {
        isUserExists(registerUserRequestDto);
        saveUser(registerUserRequestDto);
    }

    @Override
    public void updateUser(UUID userId, UpdateUserRequestDto updateUserRequestDto) {
        User userToUpdate = findUser(userId);
        updateUser(userToUpdate, updateUserRequestDto);
    }

    @Override
    public void deleteUser(UUID userId) {
        User userToDelete = findUser(userId);
        userRepository.delete(userToDelete);
    }

    private void saveUser(RegisterUserRequestDto registerUserRequestDto) {
        try {
            userRepository.save(userMapper.toUser(registerUserRequestDto));
        }catch (RuntimeException ex){
            throw new RegistrationException(FAILED_TO_REGISTER_USER);
        }
    }

    private void isUserExists(RegisterUserRequestDto registerUserRequestDto) {
        if(userRepository.existsByEmail(registerUserRequestDto.email()))
            throw new UserAlreadyExistsException(USER_ALREADY_EXISTS_MESSAGE);
    }

    private User findUser(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND_MESSAGE));
    }

    private void updateUser(User user, UpdateUserRequestDto updateUserRequestDto) {
        try {
            userMapper.updateUser(user, updateUserRequestDto);
            userRepository.save(user);
        }catch (RuntimeException ex){
            throw new UserUpdateException(FAILED_TO_UPDATE_USER);
        }
    }

    private void deleteUser(User user) {
        try{
            userRepository.deleteById(user.getId());
        }catch (RuntimeException ex){
            throw new UserDeletionException(FAILED_TO_DELETE_USER);
        }
    }
}
