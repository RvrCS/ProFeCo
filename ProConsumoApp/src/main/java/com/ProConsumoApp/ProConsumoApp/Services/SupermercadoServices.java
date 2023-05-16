package com.ProConsumoApp.ProConsumoApp.Services;

import com.ProConsumoApp.ProConsumoApp.DTOs.ProductoDTO;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class SupermercadoServices {

    private final String SUPERMERCADO_URL = "http://localhost:8082/supermercado";

    public List<ProductoDTO> getProductos(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<ProductoDTO>> response = restTemplate.exchange(
                SUPERMERCADO_URL + "/productos",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductoDTO>>(){});

        return response.getBody();
    }



}
