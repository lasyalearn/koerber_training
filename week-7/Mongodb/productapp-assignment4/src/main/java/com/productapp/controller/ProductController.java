package com.productapp.controller;

import com.productapp.repo.Product;
import com.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    // Get product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return productService.getById(id);
    }

    // Create a new product
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    // Update an existing product
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    // Delete a product by ID
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.delete(id);
    }

    // Get products with quantity less than a given value
    @GetMapping("/qty/less/{qty}")
    public List<Product> getProductsByQtyLessThan(@PathVariable Integer qty) {
        return productService.getProductsByQtyLessThan(qty);
    }

    // Get products with pages greater than or equal to a given value
    @GetMapping("/pages/greater/{qty}")
    public List<Product> getProductdByPagesGreaterThanEqual(@PathVariable Integer qty) {
        return productService.getProductdByPagesGreaterThanEqual(qty);
    }

    // Get products by exact quantity
    @GetMapping("/qty/{qty}")
    public List<Product> getProductsByQty(@PathVariable Integer qty) {
        return productService.getProductsByQty(qty);
    }

    // Get products by vendor name
    @GetMapping("/vendor/{vendor}")
    public List<Product> getProductsByVendor(@PathVariable String vendor) {
        return productService.getProductsByVendor(vendor);
    }

    // Get products by vendor and cost
    @GetMapping("/vendor/{vendor}/cost/{cost}")
    public List<Product> getProductsByVendorAndCost(@PathVariable String vendor, @PathVariable Double cost) {
        return productService.getProductsByVendorAndCost(vendor, cost);
    }

    // Get products by vendor or name
    @GetMapping("/vendor/{vendor}/or/name/{name}")
    public List<Product> getProductsByVendorOrName(@PathVariable String vendor, @PathVariable String name) {
        return productService.getProductsByVendorOrName(vendor, name);
    }

    // Get product count by vendor
    @GetMapping("/vendor/{vendor}/count")
    public Integer getProductsCountByVendor(@PathVariable String vendor) {
        return productService.getProductsCountByVendor(vendor);
    }

    // Get products by vendor sorted by name
    @GetMapping("/vendor/{vendor}/sorted")
    public List<Product> getProductsByVendorSortByName(@PathVariable String vendor) {
        return productService.getProductsByVendorSortByName(vendor);
    }

    // Get product name and vendor by quantity
    @GetMapping("/qty/{qty}/name-vendor")
    public List<Product> getProductNameAndVendorByQty(@PathVariable Integer qty) {
        return productService.getProductNameAndVendorByQty(qty);
    }

    // Get all products by vendor
    @GetMapping("/vendor/{vendor}/all")
    public List<Product> getAllProductByVendor(@PathVariable String vendor) {
        return productService.getAllProductByVendor(vendor);
    }

    // Get products by vendor using regex
    @GetMapping("/vendor/{vendor}/regex")
    public List<Product> getProductsByVendorRegEx(@PathVariable String vendor) {
        return productService.getProductsByVendorRegEx(vendor);
    }
}
