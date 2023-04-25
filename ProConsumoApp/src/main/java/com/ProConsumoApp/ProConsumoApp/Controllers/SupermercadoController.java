package com.ProConsumoApp.ProConsumoApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/supermercado")
public class SupermercadoController {


    @GetMapping("/home")
    public String supermercadoHome(){
        return "index-supermercado";
    }

}
