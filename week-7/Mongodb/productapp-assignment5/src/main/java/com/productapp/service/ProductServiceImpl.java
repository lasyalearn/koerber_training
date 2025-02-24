package com.productapp.service;

import com.productapp.repo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private MongoTemplate mongoTemplate;

    // Insert a single product
    public Product save(Product product) {
        return mongoTemplate.insert(product, "products");
    }

    // Insert multiple products
    public List<Product> saveAll(List<Product> products) {
        mongoTemplate.insertAll(products);
        return mongoTemplate.findAll(Product.class);
    }

    // Get all products
    public List<Product> getAll() {
        return mongoTemplate.findAll(Product.class);
    }

    // Get product by ID
    public Product getById(String id) {
        return mongoTemplate.findById(id, Product.class);
    }

    // Update product by ID
    public Product update(String id, Product product) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));

        Update update = new Update();
        update.set("name", product.getName());
        update.set("cost", product.getCost());
        update.set("qty", product.getQty());
        update.set("vendor", product.getVendor());

        return mongoTemplate.findAndModify(query, update, Product.class);
    }

    // Delete product by ID
    public void delete(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.findAndRemove(query, Product.class);
    }

    // Delete all products with cost greater than 1000
    public void deleteAllByCostGreaterThan(double cost) {
        Query query = new Query();
        query.addCriteria(Criteria.where("cost").gte(cost));
        mongoTemplate.findAllAndRemove(query, Product.class);
    }

    // Update multiple products with qty <= 180
    public void updateProductsWithLowQty() {
        Query query = new Query();
        query.addCriteria(Criteria.where("qty").lte(180));
        Update update = new Update();
        update.set("cost", 999.0);
        mongoTemplate.updateMulti(query, update, Product.class);
    }

    // Find products by vendor
    public List<Product> getProductsByVendor(String vendor) {
        Query query = new Query();
        query.addCriteria(Criteria.where("vendor").is(vendor));
        return mongoTemplate.find(query, Product.class);
    }

    // Find products where qty > given qty
    public List<Product> getProductsByQtyGreaterThan(int qty) {
        Query query = new Query();
        query.addCriteria(Criteria.where("qty").gt(qty));
        return mongoTemplate.find(query, Product.class);
    }

    // Upsert operation (Update or Insert)
    public void upsertProduct(String id, Product product) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("name", product.getName());
        update.set("cost", product.getCost());
        update.set("qty", product.getQty());
        update.set("vendor", product.getVendor());
        mongoTemplate.upsert(query, update, Product.class);
    }
}
