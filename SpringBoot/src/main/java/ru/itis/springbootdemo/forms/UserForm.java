package ru.itis.springbootdemo.forms;

import lombok.Data;

@Data
public class UserForm {
    private String email;
    private String password;
    private String name;
    private String surname;
    private String city;
    private String number;
}
