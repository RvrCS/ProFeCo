package com.ProConsumoApp.ProConsumoApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profeco")
public class ProfecoController {


    @GetMapping("/home")
    private String profecoHome(){
        return "index-profeco";

    }
}
