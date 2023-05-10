package com.ProConsumoApp.Supermercadoservice.Supermercadoservice.DTO;

import javax.persistence.*;

@Entity
@Table(name = "user")
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
