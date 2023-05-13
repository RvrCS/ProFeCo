package com.ProConsumoApp.ProConsumoApp.ApiControllers;

import com.ProConsumoApp.ProConsumoApp.DTOs.UserDTO;
import com.ProConsumoApp.ProConsumoApp.Models.User;
import com.ProConsumoApp.ProConsumoApp.Repos.UserRepo;
import com.ProConsumoApp.ProConsumoApp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> obtenerUsuarios(){

        List<User> users = userService.getAllUser();

        return ResponseEntity.ok(users);

    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> obtenerUsuarioById(@PathVariable Integer id){
        User user = userService.getUserById(id);


        return ResponseEntity.ok(user);
    }


}
