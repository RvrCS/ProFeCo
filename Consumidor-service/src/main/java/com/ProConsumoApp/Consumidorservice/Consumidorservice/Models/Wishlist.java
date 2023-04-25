package com.ProConsumoApp.Consumidorservice.Consumidorservice.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wishlist")
@Getter
@Setter
@NoArgsConstructor
public class Wishlist extends AbstractEntity {

    @Column(name = "id_user", nullable = false)
    private Integer idUser;

}
