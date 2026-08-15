package com.atm.service;


import com.atm.exception.AccountNotFoundException;
import com.atm.exception.InsufficientBalanceException;
import com.atm.exception.InvalidAmountException;
import com.atm.model.Account;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BankService {
    private Map<String, Account> accounts;

    public BankService() {
        this.accounts = new HashMap<>();
    }

    public Map<String, Account> getAccounts() {
        return this.accounts;
    }

    public void createAccount(String accountNumber, String holderName) {
        Account account = new Account(accountNumber, holderName, BigDecimal.ZERO);
        accounts.put(accountNumber, account);

    }

    public Account findAccount(String accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");

        }
        return account;


    }

    public void deposit(String accountNumber, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidAmountException("amount must be greater than zero");
        }
        Account account = findAccount(accountNumber);
        account.credit(amount);
    }

    public void withdraw(String accountNumber, BigDecimal amount) {
        Account account = findAccount(accountNumber);
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidAmountException("Amount must be greater than zero");
        }

        if (account.getBalance().compareTo(amount) >= 0) {
            account.debit(amount);


        } else {
            throw new InsufficientBalanceException("insufficient funds");
        }


    }

    public BigDecimal getBalance(String accountNumber) {
        Account account = findAccount(accountNumber);
        return account.getBalance();
    }


}







