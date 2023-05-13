package com.ProConsumoApp.Supermercadoservice.Supermercadoservice.DTO;

import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.Models.Producto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

@Getter
@Setter
@NoArgsConstructor
public class ProductoDTO {

    private String nombre;
    private float precio;
    private String descripcion;
    private String nombreUsuario;

    public ProductoDTO(Producto producto, UserDTO userDTO) {
        this.nombre = producto.getNombre();
        this.precio = producto.getPrecio();
        this.descripcion = producto.getDescripcion();
        this.nombreUsuario = userDTO.getNombreEmpresa();
    }
}
