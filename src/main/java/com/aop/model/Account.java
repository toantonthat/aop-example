package com.aop.model;

public class Account {
    private String owner;
    private String currency;
    private int balance;

    public Account(String owner, String currency, int balance) {
        this.owner = owner;
        this.currency = currency;
        this.balance = balance;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public String getCurrency() {
        return currency;
    }

    public int getBalance() {
        return balance;
    }
}
