package com.bc.spring.proxy;

import com.bc.spring.proxy.impl.CalculatorImpl;

//目标Calculator的静态代理类
public class CalculatorStaticProxy implements Calculator{
    private CalculatorImpl targetcalculatorImpl;

    //有参构造为目标对象赋值
    public CalculatorStaticProxy(CalculatorImpl targetcalculatorImpl) {
        this.targetcalculatorImpl = targetcalculatorImpl;
    }

    @Override
    public int add(int i, int j) {
        int result= 0;
        try {
            System.out.println("日志，方法：add，参数："+i+","+j);
            result = targetcalculatorImpl.add(i, j);
            System.out.println("日志，方法：add，结果:"+result);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("add出错了");
        } finally {
            System.out.println("add方法结束了");
        }
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("日志，方法：sub，参数："+i+","+j);
        int result=targetcalculatorImpl.sub(i, j);
        System.out.println("日志，方法：sub，结果:"+result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("日志，方法：mul，参数："+i+","+j);
        int result=targetcalculatorImpl.mul(i, j);
        System.out.println("日志，方法：mul，结果:"+result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("日志，方法：div，参数："+i+","+j);
        int result=targetcalculatorImpl.div(i, j);
        System.out.println("日志，方法：div，结果:"+result);
        return result;
    }
}
