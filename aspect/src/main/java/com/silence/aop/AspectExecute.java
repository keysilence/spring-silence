package com.silence.aop;

/**
 * Created by Silence on 2018/4/25.
 */
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AspectExecute {

    @Pointcut("execution(* com.silence.demo.aspect.bussiness.*.*(..))")
    private void allMethod() {

    }

    @Before("allMethod()")
    public void beforeMethod(JoinPoint joinPoint) {

        System.out.println("before method");

    }

    @After("allMethod()")
    public void afterMethod(JoinPoint joinPoint) {

        System.out.println("after method");

    }

    @AfterReturning(value="allMethod()", returning="result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {

        System.out.println("after returning method");

    }

    @AfterThrowing(value="allMethod()", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Exception ex) {

        System.out.println("after throwing method");

    }

    @Around("allMethod()")
    public void aroundMethod(ProceedingJoinPoint pjd) {

        System.out.println("around method start");
        try {
            //此处需显示的执行目标方法，否则目标方法将不执行
            Object result = pjd.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around method end");

    }

}
