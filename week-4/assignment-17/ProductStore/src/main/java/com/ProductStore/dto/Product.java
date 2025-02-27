package com.ProductStore.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    @NotNull(message = "Product id cannot be null")
    private int id;
    @Column(name="product_name")
    @NotBlank(message = "Product name cannot be null")
    private String name;
    @Column(name="product_price")
    @NotNull(message = "Product price cannot be null")
    private BigDecimal price;
    @Column(name="product_mfg_date")
    @NotNull(message = "Product mfg date cannot be null")
    private LocalDate mfgDate;
    public Product(String name, BigDecimal price, LocalDate mfgDate)
    {
        this.name=name;
        this.price=price;
        this.mfgDate=mfgDate;
    }

}

