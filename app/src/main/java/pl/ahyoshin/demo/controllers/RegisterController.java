package pl.ahyoshin.demo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.ahyoshin.demo.UserRepository;
import pl.ahyoshin.demo.entities.UserEntity;
import pl.ahyoshin.demo.requests.RegisterRequest;

@RestController
public class RegisterController {
    private final UserRepository userRepository;

    public RegisterController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest registerRequest){
        userRepository.saveUser(registerRequest);
    }

}
