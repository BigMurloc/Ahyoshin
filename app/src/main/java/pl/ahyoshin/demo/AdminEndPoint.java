package pl.ahyoshin.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AdminEndPoint {
    public AdminEndPoint() {
    }

    @PreAuthorize("hasAnyAuthority('Admin')")
    @GetMapping({"/Admin"})
    public void test() {
    }
}

