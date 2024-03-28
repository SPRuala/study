package com.bc.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactorySuccinct {
    private Object target;

    public ProxyFactorySuccinct(Object target) {
        this.target = target;
    }

    public Object getProxy(){
        ClassLoader classLoader=this.getClass().getClassLoader();
        Class<?>[] interfaces=target.getClass().getInterfaces();
        InvocationHandler invocationHandler=new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result=method.invoke(target, args);
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
