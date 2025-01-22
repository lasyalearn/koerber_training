package com.keorber.customercontoller;

import com.keorber.customerdto.Customer;
import com.keorber.customerservice.CustomerService;
import com.keorber.customerservice.CustomerServiceImp;

public class Main
{
    public static void main(String[] args)
    {
        CustomerService customerService=new CustomerServiceImp();
        Customer customer=customerService.getCustomerById(2);
        System.out.println(customer);
        customerService.addCustomer(new Customer(6,"ekta","delhi","1234567890"));
    }
}
