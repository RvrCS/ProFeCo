package com.ProConsumoApp.ProConsumoApp.Controllers;

import com.ProConsumoApp.ProConsumoApp.Models.Role;
import com.ProConsumoApp.ProConsumoApp.Models.User;
import com.ProConsumoApp.ProConsumoApp.Repos.UserRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(@RequestParam("email") String userEmail,
                                    @RequestParam("password") String userPsswd){

        User user = userRepo.findByEmail(userEmail);
        if(user == null) return null;

        if(user.getPassword().equals(userPsswd)){
            if(user.getRole() == Role.CONSUMIDOR){
                return "redirect:/consumidor/home";
            }
            if(user.getRole() == Role.SUPERMERCADO){
                return "redirect:/supermercado/home";
            }
            if(user.getRole() == Role.PROFECO){
                return "redirect:/profeco/home";
            }

        }

        return "redirect:/login?error";
    }


}
