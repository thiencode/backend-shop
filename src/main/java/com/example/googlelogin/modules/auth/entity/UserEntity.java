package com.example.googlelogin.modules.auth.entity;

import com.example.googlelogin.entity.Audit;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity extends Audit<UUID> {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(
            name = "id",
            insertable = false,
            columnDefinition = "uuid",
            updatable = false,
            nullable = false
    )
    private UUID userId;

    @Column(
            name = "username",
            nullable = false

    )
    private String username;


    private String password;

    private String email;


    /*    private String firstname;
    private String lastname;
    private String phone;*/


}
