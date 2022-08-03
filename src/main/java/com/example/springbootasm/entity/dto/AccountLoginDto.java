package com.example.springbootasm.entity.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountLoginDto {
    private String username;
    private String password;
}