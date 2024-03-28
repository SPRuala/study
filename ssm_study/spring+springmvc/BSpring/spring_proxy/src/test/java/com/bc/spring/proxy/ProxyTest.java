package com.bc.spring.proxy;

import com.bc.spring.proxy.impl.CalculatorImpl;
import org.junit.Test;

public class ProxyTest {
    @Test
    public void testStaticProxyTest(){
        CalculatorStaticProxy calculatorStaticProxy=new CalculatorStaticProxy(new CalculatorImpl());
        calculatorStaticProxy.add(1, 2);
    }
    @Test
    public void testProxyByFactory(){
        ProxyFactory proxyFactory=new ProxyFactory(new CalculatorImpl());
        //动态代理自动生成代理类 不知道代理类名 向上转型
       Calculator proxy= (Calculator) proxyFactory.getProxy();
       proxy.add(1, 1);
    }
    @Test
    public void testProxyByFactorySuccinct(){
        ProxyFactory proxyFactory=new ProxyFactory(new CalculatorImpl());
        Calculator proxy= (Calculator) proxyFactory.getProxy();
        proxy.sub(1, 2);
    }
}
