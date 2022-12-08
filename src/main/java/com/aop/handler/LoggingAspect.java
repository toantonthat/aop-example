package com.aop.handler;

import com.aop.model.Account;
import com.aop.service.impl.AccountServiceImpl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class LoggingAspect extends AspectHandler {

    public LoggingAspect(Object targetObject) {
        super.setTargetObject(targetObject);
    }

    @Override
    boolean before(Object targetObject, Method method, Object[] args) {
        initializeAccount();
        System.out.printf("Handling before actual method `%s` execute %n", method.getName());
        return true;
    }

    @Override
    boolean after(Object targetObject, Method method, Object[] args) {
        System.out.printf("Handling after actual method `%s` execute%n", method.getName());
        System.out.println("----");
        return true;
    }

    @Override
    boolean afterException(Object targetObject, Method method, Object[] args, Throwable throwable) {
        System.out.printf("Handling after actual method `%s` exception", method.getName());
        return true;
    }

    private void initializeAccount() {
        try {
            Object targetObject = getTargetObject();
            Field fieldList = ((AccountServiceImpl) targetObject).getClass().getDeclaredField("accountList");
            fieldList.setAccessible(true);
            List<Account> accountList = (List<Account>) fieldList.get(targetObject);
            if (accountList.isEmpty()) {
                accountList.add(new Account("Mr. A", "USD", 10000));
                accountList.add(new Account("Mr. B", "USD", 15000));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
