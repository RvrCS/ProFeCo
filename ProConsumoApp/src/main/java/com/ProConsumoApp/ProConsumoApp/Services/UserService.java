package com.ProConsumoApp.ProConsumoApp.Services;

import com.ProConsumoApp.ProConsumoApp.Models.User;
import com.ProConsumoApp.ProConsumoApp.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    public List<User> getAllUser(){
        List<User> users = userRepo.findAll();

        return users;
    }


    public User getUserById(Integer id){

        return userRepo.findById(id).orElse(null);

    }

}
