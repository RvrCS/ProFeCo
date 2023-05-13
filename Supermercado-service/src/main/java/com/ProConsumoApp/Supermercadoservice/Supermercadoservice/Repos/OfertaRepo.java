package com.ProConsumoApp.Supermercadoservice.Supermercadoservice.Repos;

import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.Models.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfertaRepo extends JpaRepository<Oferta,Integer> {



}
