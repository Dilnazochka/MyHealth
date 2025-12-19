package kg.alatoo.myhealth.service;

import kg.alatoo.myhealth.entity.User;
import java.util.Optional;

public interface UserService {
    User register(User user);
    Optional<User> findByEmail(String email);
    User findById(Long id);
    void enableUser(User user);
}