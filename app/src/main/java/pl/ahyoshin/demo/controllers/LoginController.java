package pl.ahyoshin.demo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.ahyoshin.demo.UnauthorizedException;
import pl.ahyoshin.demo.requests.LoginRequest;

@RestController
public class LoginController {
    private final AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping({"/login"})
    public void login(@RequestBody LoginRequest loginRequest) {
        boolean isLogged = this.authenticationService.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (!isLogged) {
            throw new UnauthorizedException();
        }
    }
}
