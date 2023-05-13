package com.ProConsumoApp.Consumidorservice.Consumidorservice.Repos;

import com.ProConsumoApp.Consumidorservice.Consumidorservice.Models.DetalleWishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleWishlistRepo extends JpaRepository<DetalleWishlist, Integer> {


}
