package com.ProConsumoApp.Consumidorservice.Consumidorservice.DTOs;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
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
    private String categoria;

    @Transient
    private SupermercadoDTO supermercadoDTO;

}
