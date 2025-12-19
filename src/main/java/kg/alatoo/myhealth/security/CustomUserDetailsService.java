package kg.alatoo.myhealth.security;


import kg.alatoo.myhealth.entity.User;
import kg.alatoo.myhealth.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository repo;
    public CustomUserDetailsService(UserRepository repo){ this.repo = repo; }
    @Override
    public CustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        User user = repo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new CustomUserDetails(user);
    }
}