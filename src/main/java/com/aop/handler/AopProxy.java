package com.aop.handler;

import java.lang.reflect.Proxy;

public class AopProxy {
    private AopProxy() {}

    /*
    * Creates a proxy from given  {@link com.aop.handler.AspectHandler}.
    */
    public static <T> T getProxy(AspectHandler aspectHandler) {
        final Object targetObject = aspectHandler.getTargetObject();
        return (T) Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(), aspectHandler);
    }
}
