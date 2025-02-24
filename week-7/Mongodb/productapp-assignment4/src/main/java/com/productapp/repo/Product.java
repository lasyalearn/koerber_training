package com.productapp.repo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String name;
    private Integer qty;
    private String vendor;
    private Double cost;

    public Product(String name, Integer qty, String vendor, Double cost) {
        this.name = name;
        this.qty = qty;
        this.vendor = vendor;
        this.cost = cost;
    }
    // getters
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Integer getQty() {
        return qty;
    }
    public String getVendor() {
        return vendor;
    }
    public Double getCost() {
        return cost;
    }
    //setters
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setQty(Integer qty) {
        this.qty = qty;
    }
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    public void setCost(Double cost) {
        this.cost = cost;
    }
}