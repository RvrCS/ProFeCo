package com.ProConsumoApp.ProConsumoApp.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductoDTO implements Serializable {

    private String nombre;
    private float precio;
    private String descripcion;
    private String nombreUsuario;



}
