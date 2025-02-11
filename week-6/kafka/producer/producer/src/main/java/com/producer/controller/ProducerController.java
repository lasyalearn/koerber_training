package com.producer.controller;


import com.producer.dto.Order;
import com.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController
{
    @Autowired
    private ProducerService producerService;

    @PostMapping("send")
    public String sendMessage(@RequestBody Order order)
    {
        producerService.sendMessage(order);
        return "Message sent successfully";
    }
}
