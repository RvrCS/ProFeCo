package com.ProConsumoApp.ProConsumoApp.Controllers;

import com.ProConsumoApp.ProConsumoApp.DTOs.ProductoDTO;
import com.ProConsumoApp.ProConsumoApp.Services.ApiGatewayService;
import com.ProConsumoApp.ProConsumoApp.Services.SupermercadoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
@RequestMapping("/consumidor")
@PreAuthorize("hasAuthority('CONSUMIDOR')")
public class ConsumidorController {

    @Autowired
    ApiGatewayService apiGatewayService;

    @GetMapping("/home")
    public String consumidorHome(Model model){
        Mono<List<ProductoDTO>> productosMono = apiGatewayService.getProductos();
        List<ProductoDTO> productosDTO = productosMono.block();
        model.addAttribute("productos", productosDTO);
        return "index-consumidor";
    }


    @GetMapping("/listaProductos")
    public String consumidorListaProductos(Model model){
        Mono<List<ProductoDTO>> productos = apiGatewayService.getProductos();
        List<ProductoDTO> productosDTO = productos.block();
        System.out.println(productos);
        model.addAttribute("productos", productos);
        return "listaProductos";
    }

}
