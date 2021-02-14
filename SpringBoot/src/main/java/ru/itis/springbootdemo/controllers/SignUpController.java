package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.springbootdemo.forms.UserForm;
import ru.itis.springbootdemo.services.interfaces.SignUpService;

@Controller
public class SignUpController {
    @Autowired
    private SignUpService signUpService;

    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "ftlh/signUp";

    }

    @PostMapping("/signUp")
    public String signUp(UserForm form) {
        signUpService.signUp(form);
        return "redirect:/users";
    }
}
