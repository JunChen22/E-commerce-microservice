package com.itsthatjun.ecommerce.dto;

import com.itsthatjun.ecommerce.enums.type.PlatformType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class LoginRequest implements Serializable {

    private final String username;

    private final String password;

    private final PlatformType platformType;
}
