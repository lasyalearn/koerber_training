package com.BankApp.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account
{
    // now i will add bot the validation an entity
    // at the last i will seperate it out
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int accountId;
    @Column(name = "customer_id")
    @NotNull(message = "Customer id cannot be null")
    private int customerId;
    @NotBlank(message = "Account holder name cannot be blank")
    @Column(name = "account_holder_name")
    private String accountHolderName;
    @NotBlank(message = "Account type cannot be blank")
    @Column(name = "account_type")
    private String accountType;
    @Range(min = 1000, max = 10000, message = "Account balance must be between 1000 and 10000")
    @NotNull(message = "Balance cannot be null")
    @Column(name = "balance")
    private BigDecimal balance;

    public Account(int customerId, String accountHolderName, String accountType, BigDecimal balance) {
        this.customerId = customerId;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.balance = balance;
    }
}
