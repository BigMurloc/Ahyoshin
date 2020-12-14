package pl.ahyoshin.demo;

import org.springframework.stereotype.Repository;
import pl.ahyoshin.demo.entities.UserEntity;
import pl.ahyoshin.demo.requests.RegisterRequest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class UserRepository {
    private final EntityManager em;

    public UserRepository(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public void saveUser(RegisterRequest registerRequest){
        var userEntity = new UserEntity();
        userEntity.setUsername(registerRequest.getUsername());
        userEntity.setPassword(registerRequest.getPassword());
        em.persist(userEntity);
    }


    public UserEntity findUserById(Long id){
        return em.createQuery("select ue from UserEntity ue where ue.id = :id", UserEntity.class)
                .setParameter("id", id)
                .getSingleResult();
    }


}
