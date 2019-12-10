package com.lzwing.testcode.springdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AspectJAudience {
    /**
     * 定义一个公共的切点
     */
    //@Pointcut("execution(* *.watch(..))")
    @Pointcut("@annotation(watch)")
    public void watch(watch watch) {

    }

    /**
     * 目标方法执行之前调用
     */
    /*@Before("watch()")
    public void silenceCellPhone() {
        System.out.println("Silencing cell phone");
    }*/

    /**
     * 目标方法执行之前调用
     */
    @Before("watch(watch)")
    public void takeSeat() {
        System.out.println("Taking seat");
    }

    /**
     * 目标方法执行完后调用
     */
    @AfterReturning("watch(watch)")
    public void applause() {
        System.out.println("CLAP CLAP CLAP");
    }

    /**
     * 目标方法发生异常时调用
     */
    @AfterThrowing("watch(watch)")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }

    /**
     * 环绕通知
     * @param p 通过它调用目标方法
     */
    @Around("watch(watch)")
    public Object aroundWatch(ProceedingJoinPoint p,watch watch) {
        Object o = null;
        try {
            System.out.println(watch.name());
            o = p.proceed();
            //System.out.println("CLAP CLAP CLAP!!!");
        } catch (Throwable e) {
            System.out.println("Demanding a refund");
        }
        return o;
    }
}