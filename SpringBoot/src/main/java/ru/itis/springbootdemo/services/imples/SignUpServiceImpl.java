package ru.itis.springbootdemo.services.imples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.forms.UserForm;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.services.interfaces.SignUpService;
import ru.itis.springbootdemo.repositories.interfaces.UserRepository;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserForm form) {
        System.out.println(form.getName());
        userRepository.save(
                User.builder()
                .email(form.getEmail())
                .password(passwordEncoder.encode(form.getPassword()))
                .name(form.getName())
                .surname(form.getSurname())
                .number(form.getNumber())
                .city(form.getCity())
                .build()
        );
    }
}
