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
        System.out.println("account size is " + accountList.size());
    }

    @Override
    public void removeAccount(Account account) {
        System.out.println("remove account " + account);
        accountList.remove(account);
    }

    @Override
    public Account updateAccount(Account account) {
        accountList.forEach(updateAccount -> {
            if (updateAccount.getOwner().equals(account.getOwner())) {
                updateAccount.setCurrency(account.getCurrency());
                updateAccount.setBalance(account.getBalance());
            }
        });
        return account;
    }

    @Override
    public int size() {
        return accountList.size();
    }
}
