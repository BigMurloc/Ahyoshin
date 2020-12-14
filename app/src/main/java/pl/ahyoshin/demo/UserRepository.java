package pl.ahyoshin.demo;

import java.util.Set;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import pl.ahyoshin.demo.entities.UserEntity;
import pl.ahyoshin.demo.requests.RegisterRequest;

@Repository
public class UserRepository {
    private final EntityManager em;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserRepository(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public void saveUser(RegisterRequest registerRequest, Set<String> authorities) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(registerRequest.getUsername());
        String password = this.passwordEncoder.encode(registerRequest.getPassword());
        userEntity.setPassword(password);
        userEntity.setAuthorities(authorities);
        this.em.persist(userEntity);
        if (userEntity.getId() == 1L) {
            authorities.add("Admin");
        } else {
            authorities.add("default");
        }

    }

    public UserEntity findUserByUsername(String username) {
        return (UserEntity)this.em.createQuery("select ue from UserEntity ue where ue.username = :username", UserEntity.class).setParameter("username", username).getSingleResult();
    }
}
