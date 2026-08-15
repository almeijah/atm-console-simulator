package com.atm.service;

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
        return accounts;
    }

    public void createAccount(String accountNumber, String holderName, BigDecimal balance) {
        Account account = new Account(accountNumber, holderName, BigDecimal.ZERO);
        accounts.put(accountNumber, account);

    }
}


