package com.aop.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class AspectHandler implements InvocationHandler {
    private Object targetObject;

    /*
    * Return target object
    */
    public Object getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(Object targetObject) {
        this.targetObject = targetObject;
    }

    /*
    * Runs before targets method. Return {@code true} if you want to run before target method
    */
    abstract boolean before(Object targetObject, Method method, Object[] args);

    /*
     * Runs after targets method. Return {@code true} if you want to run after target method
     */
    abstract boolean after(Object targetObject, Method method, Object[] args);

    /*
    * Invoke after exception
    */
    abstract boolean afterException(Object targetObject, Method method, Object[] args, Throwable throwable);

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        if (before(targetObject, method, args)) {
            try {
                result = method.invoke(targetObject, args);

            } catch (InvocationTargetException e) {
                afterException(targetObject, method, args, e.getTargetException());
            }
        }
        if (after(targetObject, method, args)) {
            return result;
        }
        return null;
    }
}
