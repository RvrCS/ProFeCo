package com.ProConsumoApp.Supermercadoservice.Supermercadoservice.Repos;

import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.Models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Integer> {

}
