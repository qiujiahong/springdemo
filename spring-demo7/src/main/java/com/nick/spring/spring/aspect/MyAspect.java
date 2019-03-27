package com.nick.spring.spring.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//标记是切面类
@Aspect
//需要将切面类交给Spring Ioc容器管理
@Component("myAspect")
public class MyAspect {

    //定义该方法是一个前置通知
//    @Before(value = "execution(* *..*.*ServiceImpl.*(..))")
//    public void before(){
//        System.out.println("注解前置通知");
//    }
//
//    @After(value = "execution(* *..*.*ServiceImpl.*(..))")
//    public void after(){
//        System.out.println("注解后置通知");
//    }

//    @AfterReturning(value = "execution(* *..*.*ServiceImpl.*(..))")
//    public void AfterReturning(){
//        System.out.println("注解后置通知");
//    }
//
//    @AfterThrowing(value = "execution(* *..*.*ServiceImpl.*(..))")
//    public void AfterThrowing(){
//        System.out.println("注解异常通知");
//    }
//
//    @Around(value = "execution(* *..*.*ServiceImpl.*(..))")
//    public Object Around(ProceedingJoinPoint joinPoint){
//
//        Object retVolue = null;
//        try {
//            System.out.println("环绕通知前");
//            Object[] args = joinPoint.getArgs();
//            retVolue = joinPoint.proceed(args);
//        }catch (Throwable e){
//            e.printStackTrace();
//        }finally {
//            System.out.println("环绕通知后");
//            return retVolue;
//        }
//    }


    @Before(value = "fn()")
    public void before(){
        System.out.println("注解前置通知");
    }

    @After(value = "fn()")
    public void after(){
        System.out.println("注解后置通知");
    }


    @Pointcut("execution(* *..*.*ServiceImpl.*(..))")
    public void fn(){ }
}
