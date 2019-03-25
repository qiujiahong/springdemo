package com.nick.spring.utils;

import com.nick.spring.service.UserService;
import com.nick.spring.service.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 主要作用是生成代理类
 */
public class MyProxyUtils {

    /**
     * 使用jdk实现动态代理
     *
     * @param service
     * @return
     */
    public static UserService getProxy(UserService service) {
        //proxy是jdk的api中的
        //第一个参数，目标对象的加载器
        //第二个参数，目标对象的接口
        //第三个参数，代理对象执行处理器
       UserService userService = (UserService) Proxy.newProxyInstance(service.getClass().getClassLoader(),
                service.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("记录日志-开始");
                        //反射代码，是反射api的用法
                        //该方法实际调用的目标对象的方法
                        Object object = method.invoke(service, args);
                        System.out.println("记录日志-结束");
                        return object;
                    }
                });
        return userService;
    }

    /**
     * 使用CgLib
     * 是基于继承方式实现
     * @param service
     * @return
     */
    public static UserService getProxyByCgLib(UserService service){
        //创建增强器
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        //设置回调函数
        enhancer.setCallback(new MethodInterceptor() {
            //methodProxy 代理之后的方法
            @Override
            public Object intercept(Object object, Method method, Object[] arg, MethodProxy methodProxy) throws Throwable {
                System.out.println("记录程序开始时间..."+System.currentTimeMillis());
                //因为代理对象是目标对象的子类
                //运行代码，实际调用的是目标对象的方法
                //object是代理对象
                Object object2 = methodProxy.invokeSuper(object,arg);
                System.out.println("记录程序结束时间..."+System.currentTimeMillis());
                return object2;
            }
        });
        //获取增强之后的对象
        UserService userService = (UserService) enhancer.create();
        return userService;
    }
}
