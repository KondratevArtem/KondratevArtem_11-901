package my.servlet.repositories;

import my.servlet.models.User;

import java.util.List;

public interface UsersRepository extends CrubRepository<User> {
    List<User> findAllByAge();
    void addCookie(String email, String uuid);
    Boolean findUser(String email, String password);
    List<User> findAllByNameStartingWith(String name);
}
