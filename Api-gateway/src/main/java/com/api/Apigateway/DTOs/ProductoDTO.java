package com.api.Apigateway.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductoDTO {

    private String nombre;
    private float precio;
    private String descripcion;
    private String nombreUsuario;


}