package com.BankApp.service;

import com.BankApp.dto.Account;
import com.BankApp.dto.Transfer;

import java.util.List;

public interface BankService
{
    public Account createAccount(Account account);
    public void updateAccount(Account account, int accountId);
    public void deleteAccountById(int accountId);
    public Account findByAccountId(int accountId);
    public List<Account> getAllAccounts();
    public void transferMoney(Transfer transfer);
    public void depositMoney(int accountId, double amount);
    public void withdrawMoney(int accountId, double amount);
}
