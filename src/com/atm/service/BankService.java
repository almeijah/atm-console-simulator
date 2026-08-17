package com.atm.service;


import com.atm.exception.InvalidAccountNumberException;
import com.atm.exception.*;
import com.atm.model.Account;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class BankService {
    private final Map<String, Account> accounts;

    public BankService() {
        this.accounts = new HashMap<>();

    }


    public Map<String, Account> getAccounts() {

        return Collections.unmodifiableMap(accounts);
    }

    public void createAccount(String accountNumber, String holderName) {
        if (accountNumber == null) {
            throw new InvalidAccountNumberException("Invalid account number");
        }
        if (accountNumber.isBlank()) {
            throw new InvalidAccountNumberException("Invalid account number");
        }

        if (holderName == null) {
            throw new InvalidHolderNameException("Invalid holder name");
        }
        if (holderName.isBlank()) {
            throw new InvalidHolderNameException("Invalid holder name");
        }

        if (accounts.containsKey(accountNumber)) {
            throw new AccountAlreadyExistsException("Account already exists");
        }
        Account account = new Account(accountNumber, holderName, BigDecimal.ZERO);
        accounts.put(accountNumber, account);

    }


    public Account findAccount(String accountNumber) {
        if (accountNumber == null) {
            throw new InvalidAccountNumberException("Invalid account number");
        }
        if (accountNumber.isBlank()) {
            throw new InvalidAccountNumberException("Invalid account number");
        }
        Account account = accounts.get(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");

        }
        return account;


    }

    public void deposit(String accountNumber, BigDecimal amount) {
        if (amount == null) {
            throw new InvalidAmountException("Invalid deposit amount");
        }
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidAmountException("Invalid deposit amount");
        }
        Account account = findAccount(accountNumber);
        account.credit(amount);
    }

    public void withdraw(String accountNumber, BigDecimal amount) {
        if (amount == null) {
            throw new InvalidAmountException("Invalid withdrawal amount");
        }
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidAmountException("Invalid withdrawal amount");
        }
        Account account = findAccount(accountNumber);

        if (account.getBalance().compareTo(amount) >= 0) {
            account.debit(amount);

        } else {
            throw new InsufficientBalanceException("Insufficient balance");
        }


    }

    public BigDecimal getBalance(String accountNumber) {
        Account account = findAccount(accountNumber);
        return account.getBalance();
    }
}







