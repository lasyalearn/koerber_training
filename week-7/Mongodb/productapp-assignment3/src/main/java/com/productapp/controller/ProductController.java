package com.productapp.controller;

import com.productapp.repo.Product;
import com.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController
{
    @Autowired
    private ProductService productService;

    //get all products
    @GetMapping("/products")
    public List<Product> getAll()
    {
        return productService.getAll();
    }
    // get product by id
    @GetMapping("/products/{id}")
    public Product getById(@PathVariable String id)
    {
        return productService.getById(id);
    }
    @PostMapping("/products")
    public Product save(@RequestBody Product product)
    {
        return productService.save(product);
    }
    @PutMapping("/products/addProduct/{id}")
    public Product update(@PathVariable String id, @RequestBody Product product)
    {
        return productService.update(id, product);
    }
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable String id)
    {
        productService.delete(id);
    }
}
