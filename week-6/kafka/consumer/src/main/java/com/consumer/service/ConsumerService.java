package com.consumer.service;



import com.producer.dto.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService
{
    @KafkaListener(topics = "order-topic", groupId = "order-topic-group-id")
    public void consumer(Order order)
    {
        System.out.println("***************************");
        System.out.println("Received message: " + order);
    }
}
