package com.ProConsumoApp.ProConsumoApp.ApiControllers;

import com.ProConsumoApp.ProConsumoApp.DTOs.ProductoDTO;
import com.ProConsumoApp.ProConsumoApp.Services.ApiGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
