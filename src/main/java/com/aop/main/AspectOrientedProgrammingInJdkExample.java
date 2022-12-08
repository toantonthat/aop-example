package com.aop.main;

import com.aop.handler.AopProxy;
import com.aop.handler.LoggingAspect;
import com.aop.model.Account;
import com.aop.service.AccountService;
import com.aop.service.impl.AccountServiceImpl;

public class AspectOrientedProgrammingInJdkExample {
    public static void main(String[] args) {
        AccountService proxy = AopProxy.getProxy(new LoggingAspect(new AccountServiceImpl()));
        Account account = new Account("ToanTT", "USD", 50000);
        proxy.addAccount(account);
        proxy.size();
        proxy.removeAccount(account);
        proxy.size();
    }
}
