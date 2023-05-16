package com.api.Apigateway.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ProductoDTO implements Serializable {

    private String nombre;
    private float precio;
    private String descripcion;
    private String nombreUsuario;


}