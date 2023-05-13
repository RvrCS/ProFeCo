package com.ProConsumoApp.ProConsumoApp.Services;

import com.ProConsumoApp.ProConsumoApp.DTOs.ProductoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiGatewayService {

    private final String APIGATEWAY_URL= "http://localhost:9000/apigateway";

    @Autowired
    private RestTemplate restTemplate;

    public List<ProductoDTO> getProductos(){
        ResponseEntity<List<ProductoDTO>> response = restTemplate.exchange(
                APIGATEWAY_URL + "/productos",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductoDTO>>(){});

        if(response.getBody() == null){
            return null;
        }
        List<ProductoDTO> productos = new ArrayList<>();
        for (ProductoDTO productoDTO: response.getBody()) {
            productos.add(productoDTO);
        }

        return productos;
    }

}
