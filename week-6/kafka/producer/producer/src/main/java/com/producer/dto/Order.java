package com.producer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order
{
    private String orderId;
    private String customerName;
    private String productName;
    private int quantity;
}
