package com.api.Apigateway.Services;

import com.api.Apigateway.DTOs.ProductoDTO;
import com.api.Apigateway.RabbitMQ.MQConfig;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

@Service
public class SupermercadoServices {

    private final String SUPERMERCADO_URL ="http://localhost:8082/supermercado";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AsyncRabbitTemplate asyncRabbitTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public CompletableFuture<List<ProductoDTO>> getProductos(){

        String message = "getProductos";


        CompletableFuture<Object> responseFuture = asyncRabbitTemplate.convertSendAndReceive(
                MQConfig.exchangeName,
                MQConfig.routingKey,
                message
        );

        return responseFuture
                .orTimeout(5, TimeUnit.SECONDS)
                .exceptionally(ex -> null)
                .thenApply(response ->{
                    if(response == null)
                        return new ArrayList<ProductoDTO>();

                    String responseString = response.toString();
                    Gson gson = new Gson();
                    return gson.fromJson(responseString, new TypeToken<List<ProductoDTO>>(){}.getType());
                });
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

    public ProductoDTO setProducto(ProductoDTO producto){
        Gson gson = new Gson();
        String json = gson.toJson(producto);
        System.out.println(json);

        try{
            Message responseMessage = rabbitTemplate.sendAndReceive(
                    MQConfig.queueProductos,
                    MessageBuilder
                            .withBody(json.getBytes())
                            .build());

            if (responseMessage != null && responseMessage.getBody() != null) {
                String responseString = new String(responseMessage.getBody());
                ProductoDTO response = gson.fromJson(responseString, ProductoDTO.class);
                return response;
            }else{
                return null;
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
