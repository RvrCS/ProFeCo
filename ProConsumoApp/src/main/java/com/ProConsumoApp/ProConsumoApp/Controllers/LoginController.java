package com.ProConsumoApp.ProConsumoApp.Controllers;

import com.ProConsumoApp.ProConsumoApp.Models.Role;
import com.ProConsumoApp.ProConsumoApp.Models.User;
import com.ProConsumoApp.ProConsumoApp.Repos.UserRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String processLoginForm(){

        return "index-consumidor";
    }

}
