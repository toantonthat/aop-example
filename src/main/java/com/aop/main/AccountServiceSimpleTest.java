package com.aop.main;

import com.aop.model.Account;
import com.aop.service.AccountService;
import com.aop.service.impl.AccountServiceImpl;

public class AccountServiceSimpleTest {
    public static void main(String[] args) {
        AccountService accountService = new AccountServiceImpl();
        Account account = new Account("ToanTT", "USD", 50000);
        accountService.addAccount(account);
    }
}
