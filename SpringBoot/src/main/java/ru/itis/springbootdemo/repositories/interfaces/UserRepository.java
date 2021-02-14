package ru.itis.springbootdemo.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootdemo.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
