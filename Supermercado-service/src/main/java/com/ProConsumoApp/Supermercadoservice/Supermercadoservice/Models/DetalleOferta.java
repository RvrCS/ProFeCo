package com.ProConsumoApp.Supermercadoservice.Supermercadoservice.Models;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "detalleoferta")
@Getter
@Setter
@NoArgsConstructor
public class DetalleOferta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalleoferta")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_oferta")
    private Oferta oferta;
}
