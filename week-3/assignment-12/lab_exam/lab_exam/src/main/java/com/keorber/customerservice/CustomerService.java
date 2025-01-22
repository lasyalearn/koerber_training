package com.keorber.customerservice;

import com.keorber.customerdto.Customer;

public interface CustomerService
{
    public Customer getCustomerById(int id);
    public Customer addCustomer(Customer customer);

}
