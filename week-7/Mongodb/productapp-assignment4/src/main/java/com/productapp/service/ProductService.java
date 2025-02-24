package com.productapp.service;

import com.productapp.repo.Product;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> getAll();
    public Product save(Product book);
    public Product update(String id, Product book);
    public void delete(String id);
    public Product getById(String id);

    // SELECT * FROM Product where qty<?
    List<Product> getProductsByQtyLessThan(Integer qty);

    // SELECT * FROM Product where qty>=?
    List<Product> getProductdByPagesGreaterThanEqual(Integer qty);

    // SELECT * FROM Product where qty=?
    List<Product> getProductsByQty(Integer pages);

    // SELECT * FROM Product where vendor = ?
    List<Product> getProductsByVendor(String vendor);

    //SELECT * FROM Product where vendor = ? and cost=?
    //@Query("{$and :[{vendor: ?0},{cost: ?1}] }")
    List<Product> getProductsByVendorAndCost(String vendor, Double cost);


    //select count(*) from Product where vendor=? or name=?
    List<Product> getProductsByVendorOrName(String vendor, String name);

    //select count(*) from Product where vendor=?
    Integer getProductsCountByVendor(String vendor);


    //Sorting //ASC
    //@Query(value = "{vendor=?0}", sort= "{name:-1}") //DESC
    List<Product> getProductsByVendorSortByName(String vendor);

    //@Query with Projection
    // only data of name & vendor properties will be displayed
    //@Query(value= "{qty: ?0}", fields="{name:1, vendor:1, cost:1, qty:1}") // will display all properties data
    List<Product> getProductNameAndVendorByQty(Integer qty);


    // SQL Equivalent : SELECT * FROM BOOK select * from books where author=?
    List<Product> getAllProductByVendor(String vendor);


    @Query("{ vendor : { $regex : ?0 } }")
    List<Product> getProductsByVendorRegEx(String vendor);
}
