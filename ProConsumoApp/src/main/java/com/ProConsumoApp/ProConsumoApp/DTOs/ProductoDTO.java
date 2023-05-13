package com.ProConsumoApp.ProConsumoApp.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductoDTO {

    private String nombre;
    private float precio;
    private String descripcion;
    private String nombreUsuario;



}
