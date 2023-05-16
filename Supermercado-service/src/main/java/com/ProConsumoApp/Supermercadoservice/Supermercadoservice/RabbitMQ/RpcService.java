package com.ProConsumoApp.Supermercadoservice.Supermercadoservice.RabbitMQ;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RpcService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendResponse(String replyTo, String correlationId, Object data){
        rabbitTemplate.convertAndSend(replyTo, data, message -> {
            message.getMessageProperties().setCorrelationId(correlationId);
            return message;
        });
    }

}
