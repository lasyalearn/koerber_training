package com.keorber.customerdao;

import com.keorber.customerdto.Customer;

public interface CustomerDao
{
    public Customer getCustomerById(int id);
    public Customer addCustomer(Customer customer);
}
