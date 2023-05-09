package com.ProConsumoApp.Consumidorservice.Consumidorservice.Repos;

import com.ProConsumoApp.Consumidorservice.Consumidorservice.Models.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReporteRepo extends JpaRepository<Reporte, Integer> {

}
