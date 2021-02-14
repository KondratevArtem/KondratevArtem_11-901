package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.services.interfaces.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getUserPage(Model model) {
        model.addAttribute("usersList", userService.getAllUsers());
        return "ftlh/user_page";
    }

    @GetMapping("/users/{user-id}")
    @ResponseBody
    public ResponseEntity<UserDto> getUsers(@PathVariable("user-id") Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

}
