package com.ProConsumoApp.Supermercadoservice.Supermercadoservice.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserEntity {

    @Id
    @Column(name = "id_user")
    private Integer id;

    @Transient
    private String email;

    @Transient
    private String nombre;

    @Transient
    private String password;

    @Transient
    private String role;

}
