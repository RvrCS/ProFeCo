package com.ProConsumoApp.Supermercadoservice.Supermercadoservice.Services;

import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.DTO.UserDTO;
import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.DTO.UserEntity;
import org.apache.catalina.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final String USER_URL = "http://localhost:8080/api/user";

    public List<UserDTO> getUsers(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<UserEntity>> response = restTemplate.exchange(
                USER_URL + "/users",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UserEntity>>(){}
        );
        List<UserDTO> userDTOlist = new ArrayList<>();
        for (UserEntity userEntity: response.getBody()) {
            userDTOlist.add(new UserDTO(userEntity));
        }
        return userDTOlist;
    }

    public UserDTO getUserID(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserEntity> response = restTemplate.exchange(
                USER_URL + "/users/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<UserEntity>(){}
        );
        if(response.getBody() == null){
            return null;
        }
        UserDTO userDTO = new UserDTO(response.getBody());

        return userDTO;
    }


}
