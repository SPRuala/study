package com.bc.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

//通过该类动态生成目标类的代理类
public class ProxyFactory {
    private Object target;//动态代理目标不确定类型 设为Obj

    public ProxyFactory(Object target) {//为代理对象赋值
        this.target = target;
    }
    //jdk动态代理
    public Object getProxy(){

        //通过反射动态代理
        //ClassLoader loader:类加载器,代理类被动态生成。 指定类加载器加载代理类。
        //                   类加载器：根类加载器：主要加载核心类库
        //                           扩展加载器：加载扩展类库
        //                           应用类加载器：加载自定义类、第三方类
        ClassLoader classLoader=this.getClass().getClassLoader();
        //Class[] interfaces:获取目标对象实现的所有接口的class对象 的数组
        // 动态生成的代理类要和目标类实现相同的接口 保证代理对象和目标对象实现功能一致
          Class<?>[] interfaces=target.getClass().getInterfaces();
        //InvocationHandler h:设置代理类中的抽象方法如何重写
        //接口中只有一个方法，可以直接使用内部类
        InvocationHandler h=new InvocationHandler() {
            //invoke：代理类中的方法如何执行
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //proxy:代理对象
                //method:要执行的方法
                //args:要执行方法的参数列表

                Object result= null;//要执行的方法：调用目标对象实现功能
                try {
                    System.out.println("日志,功能实现之前");
                    System.out.println("日志,方法:"+method.getName()+",参数:"+ Arrays.toString(args));
                    result = method.invoke(target, args);
                    System.out.println("日志,功能实现之后");
                    System.out.println("日志,方法:"+method.getName()+",结果:"+ result);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("目标对象出现异常");
                    System.out.println("异常"+e);
                }
                finally {
                    System.out.println("可以关闭资源");
                    System.out.println("方法:"+method.getName()+"执行完毕");
                }
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader,interfaces,h);//创建代理实例
    }

}
