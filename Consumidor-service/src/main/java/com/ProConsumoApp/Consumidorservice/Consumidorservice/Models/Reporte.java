package com.ProConsumoApp.Consumidorservice.Consumidorservice.Models;

import com.ProConsumoApp.Consumidorservice.Consumidorservice.DTOs.ProductoDTO;
import com.ProConsumoApp.Consumidorservice.Consumidorservice.DTOs.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reporte")
@Getter
@Setter
@NoArgsConstructor
public class Reporte{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reporte")
    protected Integer id;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_producto")
    private ProductoDTO productoDTO;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private UserDTO userDTO;

}
