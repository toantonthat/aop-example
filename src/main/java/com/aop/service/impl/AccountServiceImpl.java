package com.aop.service.impl;

import com.aop.model.Account;
import com.aop.service.AccountService;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private final List<Account> accountList = new ArrayList<>();
    @Override
    public void addAccount(Account account) {
        System.out.println("add account " + account);
        accountList.add(account);
    }

    @Override
    public void removeAccount(Account account) {
        System.out.println("remove account " + account);
        accountList.remove(account);
    }

    @Override
    public Account updateAccount(Account account) {
        return null;
    }

    @Override
    public int size() {
        System.out.println("account size is " + accountList.size());
        return accountList.size();
    }
}
