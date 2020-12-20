package pl.ahyoshin.demo;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import pl.ahyoshin.demo.entities.UserEntity;

public class AppAuthentication extends AbstractAuthenticationToken {
    private final UserEntity authenticatedUser;

    public AppAuthentication(UserEntity authenticatedUser) {
        super(toGrantedAuthorities(authenticatedUser.getAuthorities()));
        this.authenticatedUser = authenticatedUser;
        this.setAuthenticated(true);
    }

    private static Collection<? extends GrantedAuthority> toGrantedAuthorities(Set<String> authorities) {
        return (Collection)authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
    }

    public Object getCredentials() {
        return this.authenticatedUser.getPassword();
    }

    public Object getPrincipal() {
        return null;
    }
}
