package kg.alatoo.myhealth.service;


import kg.alatoo.myhealth.entity.User;
import kg.alatoo.myhealth.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo; this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        user.setEnabled(false); // until email verification
        return repo.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email){ return repo.findByEmail(email); }

    @Override
    public User findById(Long id){ return repo.findById(id).orElse(null); }

    @Override
    public void enableUser(User user){
        user.setEnabled(true); repo.save(user);
    }
}