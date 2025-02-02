package com.ProductStore.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product_table")
public class Product
{
    private int productId;
    private String productName;
    private int productPrice;
    private int productQuantity;
    private Date 
}
