package com.ProConsumoApp.ProConsumoApp.Controllers;


import com.ProConsumoApp.ProConsumoApp.Models.User;
import com.ProConsumoApp.ProConsumoApp.Repos.UserRepo;
import com.ProConsumoApp.ProConsumoApp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){

        return "index";
    }


    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "register";
    }



    @PostMapping("/register")
    public String crear(User user){
        userService.addUser(user);
        return "redirect:/login";
    }

    @GetMapping("/users")
    public String users(Model model){
        List<User> users = userService.getAllUser();
        System.out.println(users);
        model.addAttribute("users", users);
        return "users";
    }
}
