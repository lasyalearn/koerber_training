package com.keorber.customerservice;

import com.keorber.customerdao.CustomerDao;
import com.keorber.customerdao.factory.GetConnection;
import com.keorber.customerdao.implementation.CustomerDaoImpl;
import com.keorber.customerdto.Customer;
import com.keorber.exception.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerServiceImp implements CustomerService
{
    private static final Logger logger = LoggerFactory.getLogger(GetConnection.class);
    CustomerDao customerDao = new CustomerDaoImpl();
    @Override
    public Customer getCustomerById(int id)
    {
        Customer customer = null;
        logger.info("Inside getCustomerById");
        try
        {
            customer = customerDao.getCustomerById(id);
            logger.info("service of getting the user is done");
        }
        catch (DaoException e)
        {
            logger.error(e.getMessage());
            logger.error(e.getCause().toString());
        }
        return customer;
    }

    @Override
    public Customer addCustomer(Customer customer)
    {
        logger.info("Inside addCustomer");
        try
        {
            customerDao.addCustomer(customer);
            logger.info("service of added the user is done");
        }
        catch (DaoException e)
        {
            logger.error(e.getMessage());
            logger.error(e.getCause().toString());
        }
        return customer;
    }
}
