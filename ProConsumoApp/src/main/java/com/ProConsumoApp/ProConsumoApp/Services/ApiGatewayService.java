package com.ProConsumoApp.ProConsumoApp.Services;

import com.ProConsumoApp.ProConsumoApp.DTOs.ProductoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
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

    public ProductoDTO setProducto(ProductoDTO producto){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ProductoDTO> requestEntity = new HttpEntity<>(producto, headers);

        ResponseEntity<ProductoDTO> response = restTemplate.exchange(
                APIGATEWAY_URL + "/producto/save",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<ProductoDTO>(){});

        return response.getBody();
    }

}
