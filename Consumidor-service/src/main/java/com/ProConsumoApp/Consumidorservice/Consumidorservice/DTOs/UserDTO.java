package com.ProConsumoApp.Consumidorservice.Consumidorservice.DTOs;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class UserDTO {

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
