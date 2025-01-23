package com.autozen.userservice.entity.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    ADMIN("admin"),
    USER("user"),
    MECHANIC("mechanic");

    private final String name;

    @JsonValue
    public String toJson(){return this.name;}

}
