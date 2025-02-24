package com.productapp.service;

import com.productapp.repo.Product;
import com.productapp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getAll()
    {
        return productRepo.findAll();
    }

    @Override
    public Product save(Product book)
    {
        return productRepo.save(book);
    }

    @Override
    public Product update(String id, Product book)
    {
        Product productRepo1 = productRepo.findById(id).get();
        productRepo1.setName(book.getName());
        productRepo1.setCost(book.getCost());
        productRepo1.setQty(book.getQty());
        productRepo1.setVendor(book.getVendor());
        return productRepo.save(productRepo1);
    }

    @Override
    public void delete(String id)
    {
        productRepo.deleteById(id);
    }

    @Override
    public Product getById(String id)
    {
        return productRepo.findById(id).get();
    }
}
