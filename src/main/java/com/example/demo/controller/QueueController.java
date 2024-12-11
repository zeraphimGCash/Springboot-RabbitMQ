package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class QueueController {
    @Autowired
    private QueueSender queueSender;

    @GetMapping
    public String send(){
        queueSender.send("test message");
        return "ok. done";
    }
}
