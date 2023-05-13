package com.ProConsumoApp.ProConsumoApp.Controllers;

import com.ProConsumoApp.ProConsumoApp.DTOs.ProductoDTO;
import com.ProConsumoApp.ProConsumoApp.Services.SupermercadoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/supermercado")
public class SupermercadoController {




    @GetMapping("/home")
    public String supermercadoHome(){
        return "index-supermercado";
    }



}
