package com.keorber.customerdao.implementation;

import com.keorber.customerdao.CustomerDao;
import com.keorber.customerdao.factory.GetConnection;
import com.keorber.customerdto.Customer;
import com.keorber.exception.DaoException;

import java.lang.ref.PhantomReference;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerDaoImpl implements CustomerDao
{
    private static final Logger logger = LoggerFactory.getLogger(GetConnection.class);
    Connection connection= GetConnection.getConnection();
    @Override
    public Customer getCustomerById(int id)
    {
        Customer customer=null;
        try
        {
            PreparedStatement preparedStatement=connection.prepareStatement("select * from customers where id=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next())
            {
                customer=new Customer(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("address"),resultSet.getString("phone_no"));
                logger.info("Successfully have found the user with this id and returned the user");
                return customer;
            }

        } catch (SQLException e)
        {
            logger.error("Unsuccessful. Couldn't find the user with this id");
            throw new DaoException("Unable to get customer by this id",e);
        }
        return customer;
    }

    @Override
    public Customer addCustomer(Customer customer)
    {
        try
        {
            PreparedStatement preparedStatement=connection.prepareStatement("insert into customers(id,name,address,phone_no) values(?,?,?,?)");
            preparedStatement.setInt(1,customer.getId());
            preparedStatement.setString(2,customer.getName());
            preparedStatement.setString(3,customer.getAddress());
            preparedStatement.setString(4,customer.getPhone_no());
            preparedStatement.executeUpdate();
            logger.info("Successfully have added the user");

        } catch (SQLException e)
        {
            logger.error("Unsuccessful. Couldn't add the user");
            throw new DaoException("Could add the given customer",e);
        }
        return customer;
    }
}
