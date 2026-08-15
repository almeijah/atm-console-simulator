package com.atm.service;

import com.atm.model.Account;
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

}

