package com.ProConsumoApp.Consumidorservice.Consumidorservice.Models;

import com.ProConsumoApp.Consumidorservice.Consumidorservice.DTOs.ProductoDTO;
import com.ProConsumoApp.Consumidorservice.Consumidorservice.DTOs.UserDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "detallewishlist")
@Getter
@Setter
@NoArgsConstructor
public class DetalleWishlist{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detallewishlist")
    protected Integer id;

    @ManyToOne
    @JoinColumn(name = "id_wishlist")
    private Wishlist wishlist;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserDTO userDTO;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductoDTO productoDTO;


}
