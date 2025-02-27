package com.ProductStore.controller;

import com.ProductStore.dto.Product;
import com.ProductStore.service.ProductService;
import com.ProductStore.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ProductController
{
    @Autowired
    private ProductService productService;


    @GetMapping(path = "products")
    public List<Product> getAllProducts() {
        return productService.getListOfAllProducts();
    }

    ProductController(ProductServiceImpl productService)
    {
        this.productService = productService;
    }
    @GetMapping(path = "productSorted")
    public List<Product> getAllProductSorted(@RequestParam(name="field")  String field) {
        return productService.getAllProductSorted(field);
    }

    //productpage?offset=4&pageSize=20
    @GetMapping(path = "productpage")
    public Page<Product> getAllProductPage(@RequestParam(name="offset") int offset, @RequestParam(name="pageSize") int pageSize) {
        return productService.getAllProductPage(offset, pageSize);
    }

    //productpagesorted?offset=4&pageSize=20&field=id
    @GetMapping(path = "productPageSorted")
    public Page<Product> getAllProductPageSorted(int offset, int pageSize,String field) {
        return productService.getAllProductPageSorted(field, offset, pageSize);
    }

}
