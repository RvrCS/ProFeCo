package com.ProConsumoApp.ProConsumoApp.Services;

import com.ProConsumoApp.ProConsumoApp.Models.User;
import com.ProConsumoApp.ProConsumoApp.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<User> getAllUser(){
        List<User> users = userRepo.findAll();

        return users;
    }


    public User getUserById(Integer id){

        return userRepo.findById(id).orElse(null);

    }

    public String addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return "Usuario agregado";
    }

}
