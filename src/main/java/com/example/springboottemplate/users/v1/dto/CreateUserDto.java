package com.example.springboottemplate.users.v1.dto;

public class CreateUserDto {
    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public CreateUserDto(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
