package com.example.swagger.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private boolean isBlocked;
    private boolean isMarked;
}
