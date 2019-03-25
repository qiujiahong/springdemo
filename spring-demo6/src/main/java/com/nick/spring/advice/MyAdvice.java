package com.nick.spring.advice;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 通知类，增强的功能
 */
public class MyAdvice {
    public void log1(){
        System.out.println("记录日志111");
    }

    public void log2(){
        System.out.println("记录日志222");
    }
    public void log3(){
        System.out.println("记录日志333");
    }

    public void log4(){
        System.out.println("记录日志444");
    }

    /**
     * 环绕通知
     * 场景，事务管理
     * @param joinPoint
     * @throws Throwable
     */
    public void log5(ProceedingJoinPoint joinPoint)  {
        System.out.println("环绕通知前");
        //调用目标对象方法
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            System.out.println("环绕通知后");
        }
    }
}
