package com.ProConsumoApp.Supermercadoservice.Supermercadoservice.Repos;

import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.Models.DetalleOferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleOfertaRepo extends JpaRepository<DetalleOferta, Integer> {

}
