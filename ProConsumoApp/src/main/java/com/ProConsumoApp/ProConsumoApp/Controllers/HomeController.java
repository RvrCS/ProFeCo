package com.ProConsumoApp.ProConsumoApp.Controllers;


import com.ProConsumoApp.ProConsumoApp.Models.User;
import com.ProConsumoApp.ProConsumoApp.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("")
    public String index(){

        return "index";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "register";
    }



    @PostMapping("/register")
    public String crear(User user){
        userRepo.save(user);
        return "redirect:/";
    }

    @GetMapping("/users")
    public String users(Model model){
        List<User> users = userRepo.findAll();
        System.out.println(users);
        model.addAttribute("users", users);
        return "users";
    }
}
