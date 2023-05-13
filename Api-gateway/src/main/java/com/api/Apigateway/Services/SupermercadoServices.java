package com.api.Apigateway.Services;

import com.api.Apigateway.DTOs.ProductoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SupermercadoServices {

    private final String SUPERMERCADO_URL ="http://localhost:8082/supermercado";

    @Autowired
    private RestTemplate restTemplate;

    public List<ProductoDTO> getProductos(){
        ResponseEntity<List<ProductoDTO>> response = restTemplate.exchange(
                SUPERMERCADO_URL + "/productos",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductoDTO>>(){}
        );

        return response.getBody();

    }

    public ProductoDTO getProductoById(Integer id){
        ResponseEntity<ProductoDTO> response = restTemplate.exchange(
                SUPERMERCADO_URL + "/productos/"+id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ProductoDTO>(){}
        );

        return response.getBody();
    }

}
