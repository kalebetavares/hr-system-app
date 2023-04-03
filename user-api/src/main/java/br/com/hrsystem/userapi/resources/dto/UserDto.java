package br.com.hrsystem.userapi.resources.dto;

import lombok.Getter;

@Getter
public class UserDto {

    private String name;
    private String password;
    private String email;
    private Double hourlyPrice;
}
