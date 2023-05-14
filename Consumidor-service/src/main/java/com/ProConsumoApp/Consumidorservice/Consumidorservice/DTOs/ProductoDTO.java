package com.ProConsumoApp.Consumidorservice.Consumidorservice.DTOs;

import javax.persistence.*;
import org.apache.catalina.User;

@Entity
@Table(name = "producto")
public class ProductoDTO {

    @Id
    @Column(name = "id_producto")
    private Integer idProducto;


    @Transient
    private String nombre;

    @Transient
    private float precio;

    @Transient
    private String descripcion;

    @Transient
    private byte[] imagen;

    @Transient
    private UserDTO userDTO;

}
