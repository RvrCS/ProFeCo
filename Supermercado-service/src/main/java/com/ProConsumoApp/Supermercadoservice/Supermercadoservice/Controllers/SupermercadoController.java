package com.ProConsumoApp.Supermercadoservice.Supermercadoservice.Controllers;

import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.Models.Producto;
import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.Services.SupermercadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/supermercado")
public class SupermercadoController {

    @Autowired
    private SupermercadoService supermercadoService;

    @GetMapping("/productos")
    public List<Producto> getAllProductos(){
        return supermercadoService.getAllProductos();
    }

    @GetMapping("/productos/{id}")
    public Producto getProductoById(@PathVariable Integer id){
        return supermercadoService.getProductoById(id);
    }

}
