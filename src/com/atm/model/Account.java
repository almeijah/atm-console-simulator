package com.atm.model;

import java.math.BigDecimal;

public class Account {
    private String accountNumber;
    private String holderName;
    private BigDecimal balance;

    public Account() {
    }

    public Account(String accountNumber, String holderName, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void credit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            balance = balance.add(amount);

        }
    }

    public void debit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0 &&
                balance.compareTo(amount) >= 0) {
            balance = balance.subtract(amount);
            System.out.println("Debit successfully completed");
        } else {
            System.out.println("Debit denied; the withdrawal amount must be less than the balance");
        }
    }
}

