package ru.itis.springbootdemo.services.interfaces;

import ru.itis.springbootdemo.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getUserById(Long userId);
}
