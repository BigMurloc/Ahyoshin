package pl.ahyoshin.demo.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.ahyoshin.demo.AppAuthentication;
import pl.ahyoshin.demo.UserRepository;
import pl.ahyoshin.demo.entities.UserEntity;

@Component
public class AuthenticationService {
    private final UserRepository userRepository;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(String username, String password) {
        UserEntity userDB = this.userRepository.findUserByUsername(username);
        if (this.passwordEncoder.matches(password, userDB.getPassword())) {
            SecurityContextHolder.getContext().setAuthentication(new AppAuthentication(userDB));
            return true;
        }

        return false;
    }
}

