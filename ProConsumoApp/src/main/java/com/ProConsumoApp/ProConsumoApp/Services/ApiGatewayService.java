package com.ProConsumoApp.ProConsumoApp.Services;

import com.ProConsumoApp.ProConsumoApp.DTOs.ProductoDTO;
import com.ProConsumoApp.ProConsumoApp.RabbitMQ.MQConfig;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
public class ApiGatewayService {

    private final String APIGATEWAY_URL= "http://localhost:9000/apigateway";

    @Autowired
    private RestTemplate restTemplate;


    public Mono<List<ProductoDTO>> getProductos(){
        WebClient webClient = WebClient.create(APIGATEWAY_URL);

        return webClient.get()
                .uri("/productos")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<ProductoDTO>>() {})
                .onErrorResume(throwable -> Mono.just(new ArrayList<>()));

    }

    public Mono<ProductoDTO> setProducto(ProductoDTO producto) {
        WebClient webClient = WebClient.create(APIGATEWAY_URL);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = null;
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        producto.setNombreUsuario(currentUserName);
        System.out.println(producto.toString());
        return webClient.post()
                .uri("/producto/save")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(producto)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ProductoDTO>() {});
        /*RestTemplate restTemplate = new RestTemplate();
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

        return response.getBody();*/
    }

}
