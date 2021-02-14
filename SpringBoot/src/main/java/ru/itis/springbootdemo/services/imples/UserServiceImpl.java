package ru.itis.springbootdemo.services.imples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.interfaces.UserRepository;
import ru.itis.springbootdemo.services.interfaces.UserService;

import java.util.List;

import static ru.itis.springbootdemo.dto.UserDto.*;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return from(userRepository.findAll());
    }

    @Override
    public UserDto getUserById(Long userId) {
        return from(userRepository.findById(userId).orElse(User.builder().build()));
    }
}
