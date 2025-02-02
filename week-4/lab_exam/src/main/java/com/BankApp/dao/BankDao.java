package com.BankApp.dao;

import com.BankApp.dto.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankDao extends JpaRepository<Account, Integer>
{
    Account findByAccountId(int accountId); // Use 'findByAccountId' instead of 'getAccountById'
}
