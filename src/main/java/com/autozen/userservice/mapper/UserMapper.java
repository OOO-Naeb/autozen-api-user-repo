package com.autozen.userservice.mapper;

import com.autozen.userservice.dto.request.RegisterUserRequestDto;
import com.autozen.userservice.dto.request.UpdateUserRequestDto;
import com.autozen.userservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    @Mapping(target = "role", defaultValue = "USER")
    User toUser(RegisterUserRequestDto registerUserRequestDto);

    void updateUser(@MappingTarget User user,
                    UpdateUserRequestDto updateUserRequestDto);
}
