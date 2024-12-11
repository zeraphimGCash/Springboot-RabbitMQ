package com.example.demo.controller;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@RestController
@RequestMapping("/test")
public class QueueController {

    public QueueController(RabbitTemplate queueSender) {
        this.queueSender = queueSender;
    }

    private final RabbitTemplate queueSender;

//    @GetMapping
//    public String send(){
//        queueSender.send("test message");
//        return "ok. done";
//    }

    @GetMapping
    public String send(){
        String msg = "test message";

        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("jc", "diamante");
        Message message = new Message(msg.getBytes(), messageProperties);

        queueSender.convertAndSend("test-exchange", "routing-key-test", message);
        return "ok. done";
    }
}
