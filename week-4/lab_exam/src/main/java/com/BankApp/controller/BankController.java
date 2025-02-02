package com.BankApp.controller;

import com.BankApp.dto.Account;
import com.BankApp.dto.Transfer;
import com.BankApp.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BankController
{
    BankService bankService;
    @Autowired
    public BankController(BankService bankService)
    {
        this.bankService = bankService;
    }
    //create bank account
    @PostMapping("/addAccount")
    public ResponseEntity<Account> createAccount(@RequestBody Account account)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(bankService.createAccount(account));
    }

    //update bank account
    @PutMapping("/updateAccount/{accountId}")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account, @PathVariable int accountId)
    {
        bankService.updateAccount(account, accountId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    //delete bank account
    @DeleteMapping("/deleteAccount/{accountId}")
    public ResponseEntity<Account> deleteAccount(@PathVariable int accountId)
    {
        bankService.deleteAccountById(accountId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //get bank account by id
    @GetMapping("/getAccount/{accountId}")
    public ResponseEntity<Account> getAccount(@PathVariable int accountId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(bankService.findByAccountId(accountId));
    }

    //get all bank accounts
    @GetMapping("/getAllAccounts")
    public ResponseEntity<List<Account>> getAllAccounts()
    {
        return ResponseEntity.status(HttpStatus.OK).body(bankService.getAllAccounts());
    }

    @PostMapping("/transferMoney")
    public ResponseEntity<String> transferMoney(@RequestBody Transfer transfer)
    {
        bankService.transferMoney(transfer);
        return ResponseEntity.status(HttpStatus.OK).body("Money transferred successfully");
    }

    //deposite money
    @PutMapping("/depositMoney/{accountId}/{amount}")
    public ResponseEntity<String> depositMoney(@PathVariable int accountId, @PathVariable double amount)
    {
        bankService.depositMoney(accountId, amount);
        return ResponseEntity.status(HttpStatus.OK).body("Money deposited successfully");
    }

    //withdraw money
    @PutMapping("/withdrawMoney/{accountId}/{amount}")
    public ResponseEntity<String> withdrawMoney(@PathVariable int accountId, @PathVariable double amount)
    {
        bankService.withdrawMoney(accountId, amount);
        return ResponseEntity.status(HttpStatus.OK).body("Money withdrawn successfully");
    }

}
