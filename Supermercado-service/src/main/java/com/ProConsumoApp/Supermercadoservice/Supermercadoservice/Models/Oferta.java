package com.ProConsumoApp.Supermercadoservice.Supermercadoservice.Models;

import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.DTO.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "oferta")
@Getter
@Setter
@NoArgsConstructor
public class Oferta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oferta")
    private Integer id;

    @Column(name = "descuento", nullable = false)
    private float descuento;

    @Column(name = "duracion", nullable = false)
    private Integer duracion;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @OneToMany(mappedBy = "oferta")
    private List<DetalleOferta> detalles;


}
