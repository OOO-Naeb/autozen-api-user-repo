package com.autozen.userservice.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageConstants {
    public static final String FIRST_NAME_REQUIRED = "First name is required";
    public static final String FIRST_NAME_LENGTH_MESSAGE = "First name must be between 2-30 characters of Latin origin";
    public static final String FIRST_NAME_SPACES_MESSAGE = "First name must start and end with a character of Latin origin";
    public static final String NAME_FORMAT_MESSAGE = "Invalid name format";
    public static final String LAST_NAME_REQUIRED = "Last name is required";
    public static final String LAST_NAME_LENGTH_MESSAGE = "Last name must be between 2-30 characters of Latin origin";
    public static final String LAST_NAME_SPACES_MESSAGE = "Last name must start and end with a character of Latin origin";
    public static final String PHONE_NUMBER_REQUIRED = "Phone number is required";
    public static final String PHONE_VALIDATION_MESSAGE = "Invalid phone number format";
    public static final String EMAIL_REQUIRED = "Email is required";
    public static final String EMAIL_VALIDATION_MESSAGE = "Invalid email format";
    public static final String PASSWORD_REQUIRED = "Password is required";
    public static final String PASSWORD_VALIDATION_MESSAGE = "Invalid password format";
    public static final String USER_ALREADY_EXISTS_MESSAGE = "User already exists";
    public static final String FAILED_TO_REGISTER_USER = "Failed to register user";
    public static final String USER_NOT_FOUND_MESSAGE = "User not found";
    public static final String FAILED_TO_UPDATE_USER = "Failed to update user";
    public static final String FAILED_TO_DELETE_USER = "Failed to delete user";
}
