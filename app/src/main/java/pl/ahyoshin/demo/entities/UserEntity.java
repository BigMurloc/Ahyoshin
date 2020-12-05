package pl.ahyoshin.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public void setId(Long id) { this.id = id; }

    public Long getId() { return id; }
}
