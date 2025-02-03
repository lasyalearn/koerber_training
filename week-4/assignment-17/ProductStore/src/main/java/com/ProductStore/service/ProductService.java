package com.ProductStore.service;

import com.ProductStore.dto.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ProductService
{

    List<Product> getListOfAllProducts();
    List<Product> getListOfAllProductsBasedOnName(String name);
    List<Product> getListOfAllProductsBasedOnNameV2(@Param("name")  String name);
    List<Product> getListOfAllProductsBasedOnNameAndPrice(String name, BigDecimal price);
    List<Product> getListOfAllProductsBasedOnNameOrPrice(String name, BigDecimal price);
    List<Product> findByName(String name);
    List<Product> findByNameContaining(String name);
    List<Product> findByNameLike(String name);
    List<Product> findByNameStartingWith(String name);
    List<Product> findByNameEndingWith(String name);
    List<Product> findByNameIgnoreCase(String name);
    List<Product> findByMfgDateAfter(LocalDate date);
    List<Product> findByMfgDateBefore(LocalDate date);
    List<Product> findByMfgDateBetween(LocalDate date1, LocalDate date);

    Page<Product> getAllProductPageSorted(String field, int offset, int pageSize);

    Page<Product> getAllProductPage(int offset, int pageSize);

    List<Product> getAllProductSorted(String field);
}
