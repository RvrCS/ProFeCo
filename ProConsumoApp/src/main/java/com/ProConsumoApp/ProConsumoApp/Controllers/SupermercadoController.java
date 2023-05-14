package com.ProConsumoApp.ProConsumoApp.Controllers;

import com.ProConsumoApp.ProConsumoApp.DTOs.ProductoDTO;
import com.ProConsumoApp.ProConsumoApp.Services.ApiGatewayService;
import com.ProConsumoApp.ProConsumoApp.Services.SupermercadoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/supermercado")
@PreAuthorize("hasAuthority('SUPERMERCADO')")
public class SupermercadoController {


    @Autowired
    private ApiGatewayService apiGatewayService;

    @GetMapping("/home")
    public String supermercadoHome(){
        return "index-supermercado";
    }


    @GetMapping("/producto")
    public String supermercadoProducto(Model model){
        model.addAttribute("producto", new ProductoDTO());
        return "producto";
    }

    @PostMapping("/producto")
    public String agregarProducto(@ModelAttribute("producto")ProductoDTO productoDTO){
        apiGatewayService.setProducto(productoDTO);
        return "redirect:/supermercado/home";
    }




}
