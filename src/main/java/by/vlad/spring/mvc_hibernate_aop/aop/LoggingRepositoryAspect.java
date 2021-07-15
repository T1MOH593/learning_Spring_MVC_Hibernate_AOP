package by.vlad.spring.mvc_hibernate_aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Aspect
public class LoggingRepositoryAspect {

    @Around("execution(* by.vlad.spring.mvc_hibernate_aop.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        var methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        var methodName = methodSignature.getName();
        System.out.println("Begin of " + methodName);
        var result = proceedingJoinPoint.proceed();
        System.out.println("End of " + methodName);
        System.out.println("------------------------------");
        return result;
    }
}
