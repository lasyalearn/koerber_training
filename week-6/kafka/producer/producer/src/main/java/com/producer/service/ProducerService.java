package com.producer.service;


import com.producer.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class ProducerService
{
    KafkaTemplate<String, Order> kafkaTemplate;

    @Autowired
    public ProducerService(KafkaTemplate<String, Order> kafkaTemplate)
    {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Order order)
    {
        System.out.println("**********************************************");
        System.out.println(order);
        System.out.println("Sending message");
        kafkaTemplate.send("order-topic", order);
    }
}
