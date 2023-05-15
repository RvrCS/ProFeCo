package com.ProConsumoApp.ProConsumoApp.Services;

import com.ProConsumoApp.ProConsumoApp.DTOs.ProductoDTO;
import com.ProConsumoApp.ProConsumoApp.RabbitMQ.MQConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public ProductoDTO setProducto(ProductoDTO producto) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ProductoDTO> requestEntity = new HttpEntity<>(producto, headers);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = null;
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        producto.setNombreUsuario(currentUserName);
        System.out.println(producto.toString());

        ResponseEntity<ProductoDTO> response = restTemplate.exchange(
                APIGATEWAY_URL + "/producto/save",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<ProductoDTO>() {
                });

        return response.getBody();
    }

}
