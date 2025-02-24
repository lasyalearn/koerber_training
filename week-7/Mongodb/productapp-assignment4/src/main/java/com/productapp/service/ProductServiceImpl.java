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

    @Override
    public List<Product> getProductsByQtyLessThan(Integer qty) {
        return productRepo.getProductsByQtyLessThan(qty);
    }

    @Override
    public List<Product> getProductdByPagesGreaterThanEqual(Integer qty) {
        return productRepo.getProductdByPagesGreaterThanEqual(qty);
    }

    @Override
    public List<Product> getProductsByQty(Integer pages) {
        return productRepo.getProductsByQty(pages);
    }

    @Override
    public List<Product> getProductsByVendor(String vendor) {
        return productRepo.getProductsByVendor(vendor);
    }

    @Override
    public List<Product> getProductsByVendorAndCost(String vendor, Double cost) {
        return productRepo.getProductsByVendorAndCost(vendor, cost);
    }

    @Override
    public List<Product> getProductsByVendorOrName(String vendor, String name) {
        return productRepo.getProductsByVendorOrName(vendor, name);
    }

    @Override
    public Integer getProductsCountByVendor(String vendor) {
        return productRepo.getProductsCountByVendor(vendor);
    }

    @Override
    public List<Product> getProductsByVendorSortByName(String vendor) {
        return productRepo.getProductsByVendorSortByName(vendor);
    }

    @Override
    public List<Product> getProductNameAndVendorByQty(Integer qty) {
        return productRepo.getProductNameAndVendorByQty(qty);
    }

    @Override
    public List<Product> getAllProductByVendor(String vendor) {
        return productRepo.getAllProductByVendor(vendor);
    }

    @Override
    public List<Product> getProductsByVendorRegEx(String vendor) {
        return productRepo.getProductsByVendorRegEx(vendor);
    }
}
