package com.ProConsumoApp.ProConsumoApp.ApiControllers;

import com.ProConsumoApp.ProConsumoApp.DTOs.ProductoDTO;
import com.ProConsumoApp.ProConsumoApp.Services.ApiGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ApiGatewayService apiGatewayService;

    /*@GetMapping("/productos")
    public CompletableFuture<ResponseEntity<List<ProductoDTO>>> getProductos(){
        CompletableFuture<List<ProductoDTO>> productosDTO = apiGatewayService.getProductos();
        return ResponseEntity.ok(productosDTO);
    }*/

    @PostMapping("/productos/save")
    public ResponseEntity<ProductoDTO> saveProducto(@RequestBody ProductoDTO productoDTO){
        Mono<ProductoDTO> productoMono = apiGatewayService.setProducto(productoDTO);
        ProductoDTO producto = productoMono.block();
        return ResponseEntity.ok(producto);
    }


}
