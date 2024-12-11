package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;

public class RabbitMQConfig {
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    public Queue testqQueue() {
        return new Queue("test", true);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange("direct-exchange");
    }

    @Bean
    Binding testqBinding(Queue testeQueue, DirectExchange exchange) {
        return BindingBuilder.bind(testeQueue).to(exchange).with("routing-key-test");
    }
}
