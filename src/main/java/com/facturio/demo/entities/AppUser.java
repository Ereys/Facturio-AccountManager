package com.facturio.demo.entities;

import com.facturio.demo.entities.enums.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder


public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idUser;
    private String name;

    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public AppUser(int idUser, String Julien) {
    }
}
