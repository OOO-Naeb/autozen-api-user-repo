package com.autozen.userservice.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegexConstants {
    public static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z\\s])[^\\s]{8,20}$";
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9._+-]{1,50}@[a-zA-Z0-9.-]{1,50}\\.[a-zA-Z]{2,50}$";
    public static final String PHONE_REGEX = "^\\+7\\s?\\(?\\d{3}\\)?\\s?\\d{3}[-\\s]?\\d{2}[-\\s]?\\d{2}$";
    public static final String SPACES_REGEX = "^\\S.*\\S$|^\\S$|^$";
    public static final String NAME_FORMAT_REGEX = "^[A-Za-z]+$";
}
