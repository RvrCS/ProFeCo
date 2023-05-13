package com.ProConsumoApp.Supermercadoservice.Supermercadoservice.Services;

import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.Models.Producto;
import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.Repos.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SupermercadoService {

    @Autowired
    private ProductoRepo productoRepo;



    public List<Producto> getAllProductos(){
        List<Producto> productos = productoRepo.findAll();

        return productos;
    }

    public Producto getProductoById(Integer id){

        return productoRepo.findById(id).orElse(null);

    }


}
