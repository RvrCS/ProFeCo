package com.ProConsumoApp.ProConsumoApp.Controllers;

import com.ProConsumoApp.ProConsumoApp.DTOs.ProductoDTO;
import com.ProConsumoApp.ProConsumoApp.Services.ApiGatewayService;
import com.ProConsumoApp.ProConsumoApp.Services.SupermercadoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/consumidor")
public class ConsumidorController {

    @Autowired
    ApiGatewayService apiGatewayService;

    @GetMapping("/home")
    public String consumidorHome(Model model){
        List<ProductoDTO> productosDTO = apiGatewayService.getProductos();
        model.addAttribute("productos", productosDTO);
        return "index-consumidor";
    }


    @GetMapping("/listaProductos")
    public String consumidorListaProductos(Model model){
        List<ProductoDTO> productos = apiGatewayService.getProductos();
        System.out.println(productos);
        model.addAttribute("productos", productos);
        return "listaProductos";
    }

}
