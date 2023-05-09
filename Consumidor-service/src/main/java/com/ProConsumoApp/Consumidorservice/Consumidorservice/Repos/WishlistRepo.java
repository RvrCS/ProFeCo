package com.ProConsumoApp.Consumidorservice.Consumidorservice.Repos;

import com.ProConsumoApp.Consumidorservice.Consumidorservice.Models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepo extends JpaRepository<Wishlist, Integer> {


}
