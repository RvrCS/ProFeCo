package com.api.Apigateway.RabbitMQ;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    public static final String queueName = "proconsumoapp_queue";


    public static String exchangeName = "proconsumoapp_exchange";

    public static String routingKey = "proconsumoapp_routingkey";

    public static final String queueApi = "api_queue";
    public static final String exchangeApi = "api-exchange";

    public static final String routingKeyApi = "api-routing-key";

    public static final String queueProductos = "producto_queue";

    @Bean
    public Queue queueProductos() {
        return new Queue(queueProductos, true);
    }

    // Spring bean for queue (store json messages)
    @Bean
    public Queue queue() {
        return new Queue(queueName, true);
    }

    // Spring bean for rabbitmq exchange
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchangeName);
    }

    // Spring bean for binding queue and exchange using routing key
    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(routingKey);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        rabbitTemplate.setReplyTimeout(60000);
        return rabbitTemplate;
    }

    @Bean
    public AsyncRabbitTemplate asyncRabbitTemplate(RabbitTemplate template) {
        return new AsyncRabbitTemplate(template);
    }

}
