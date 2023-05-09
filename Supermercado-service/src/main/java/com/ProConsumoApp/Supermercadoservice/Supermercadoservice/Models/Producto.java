package com.ProConsumoApp.Supermercadoservice.Supermercadoservice.Models;

import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.DTO.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "producto")
@Getter
@Setter
@NoArgsConstructor
public class Producto {

    @Id
    @Column(name = "id_producto")
    private Integer idProducto;


    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "precio", nullable = false)
    private float precio;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "imagen", nullable = false)
    private byte[] imagen;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private UserDTO userDTO;

    @OneToMany(mappedBy = "producto")
    private List<Oferta> ofertas;


}
