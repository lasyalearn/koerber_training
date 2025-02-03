package com.ProductStore.service;

import com.ProductStore.dao.ProductDao;
import com.ProductStore.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    ProductServiceImpl(ProductDao productDao)
    {
        this.productDao = productDao;
    }
    private final ProductDao productDao;


    @Override
    public List<Product> getListOfAllProducts()
    {
        return productDao.findAll();
    }

    @Override
    public List<Product> getListOfAllProductsBasedOnName(String name)
    {
        return productDao.findByName(name);
    }

    @Override
    public List<Product> getListOfAllProductsBasedOnNameV2(String name)
    {
        return productDao.getListOfAllProductsBasedOnNameV2(name);
    }

    @Override
    public List<Product> getListOfAllProductsBasedOnNameAndPrice(String name, BigDecimal price)
    {
        return productDao.getListOfAllProductsBasedOnNameAndPrice(name,price);
    }

    @Override
    public List<Product> getListOfAllProductsBasedOnNameOrPrice(String name, BigDecimal price)
    {
        return productDao.getListOfAllProductsBasedOnNameOrPrice(name,price);
    }

    @Override
    public List<Product> findByName(String name)
    {
        return productDao.findByName(name);
    }

    @Override
    public List<Product> findByNameContaining(String name)
    {
        return productDao.findByNameContaining(name);
    }

    @Override
    public List<Product> findByNameLike(String name)
    {
        return productDao.findByNameLike(name);
    }

    @Override
    public List<Product> findByNameStartingWith(String name)
    {
        return productDao.findByNameStartingWith(name);
    }

    @Override
    public List<Product> findByNameEndingWith(String name)
    {
        return productDao.findByNameEndingWith(name);
    }

    @Override
    public List<Product> findByNameIgnoreCase(String name)
    {
        return productDao.findByNameIgnoreCase(name);
    }

    @Override
    public List<Product> findByMfgDateAfter(LocalDate date)
    {
        return productDao.findByMfgDateAfter(date);
    }

    @Override
    public List<Product> findByMfgDateBefore(LocalDate date)
    {
        return productDao.findByMfgDateBefore(date);
    }

    @Override
    public List<Product> findByMfgDateBetween(LocalDate date1, LocalDate date)
    {
        return productDao.findByMfgDateBetween(date1,date);
    }
    @Override
    public Page<Product> getAllProductPageSorted(String field, int offset, int pageSize) {
        Pageable pageable = PageRequest.of(offset, pageSize, Sort.by(field));
        return productDao.findAll(pageable);
    }
    @Override
    public Page<Product> getAllProductPage(int offset, int pageSize) {
        Pageable pageable = PageRequest.of(offset, pageSize);
        return productDao.findAll(pageable);
    }
    @Override
    public List<Product> getAllProductSorted(String field) {
        return productDao.findAll(Sort.by(field));
    }
}
