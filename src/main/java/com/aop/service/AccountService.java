package com.aop.service;

import com.aop.model.Account;

public interface AccountService {
    void addAccount(Account account);
    void removeAccount(Account account);
    Account updateAccount(Account account);
    int size();
}
