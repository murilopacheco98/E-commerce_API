package com.ecommerce.educative.model.user;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tokens")
public class AuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "token")
    private String token;

    @Column(name = "created_at")
    private Date created_at;

    @OneToOne(targetEntity = UserEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private UserEntity userEntity;
    // @OneToOne(mappedBy = "userEntity")
    // private UserEntity userEntity;

    public AuthenticationToken(UserEntity userEntity) {
        this.userEntity = userEntity;
        this.created_at = new Date();
        this.token = UUID.randomUUID().toString();
    }

}
