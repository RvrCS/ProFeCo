package com.api.Apigateway.Controllers;

import com.api.Apigateway.DTOs.ProductoDTO;
import com.api.Apigateway.RabbitMQ.MQConfig;
import com.api.Apigateway.Services.SupermercadoServices;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/apigateway")
public class ApiGatewayController {

    @Autowired
    private SupermercadoServices supermercadoServices;

    @GetMapping("/productos")
    public CompletableFuture<ResponseEntity<List<ProductoDTO>>> obtenerProductos(){

            CompletableFuture<List<ProductoDTO>> productosFuture = supermercadoServices.getProductos();

            return productosFuture.thenApply(productos -> {
                if(productos == null)
                    return ResponseEntity.ok(new ArrayList<>());
                else if(productos.isEmpty())
                    return ResponseEntity.noContent().build();
                else
                    return ResponseEntity.ok(productos);
            });

    }



    @GetMapping("/productos/{id}")
    public ResponseEntity<ProductoDTO> obtenerProductoById(@PathVariable Integer id){
        ProductoDTO productoDTO = supermercadoServices.getProductoById(id);
        return ResponseEntity.ok(productoDTO);
    }

    @PostMapping("/producto/save")
    public ResponseEntity<ProductoDTO> setProducto(@RequestBody ProductoDTO productoDTO){
        System.out.println(productoDTO.toString());
        ProductoDTO producto = supermercadoServices.setProducto(productoDTO);
        return ResponseEntity.ok(producto);
    }

}
