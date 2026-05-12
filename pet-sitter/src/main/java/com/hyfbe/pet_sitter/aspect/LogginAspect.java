package com.hyfbe.pet_sitter.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {
    /** This method will run around (before and after) any method in any service class
     * You can change the pointcut expression to target specific methods or packages
     * The ".." means "any parameters"
     * The syntax is flexible and powerful — see the end of this file for more examples
     */
    @Around("execution(* com.hyfbe.pet_sitter.service.*.*(..))")
    public Object logServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        // The Throwable class is the superclass of all errors and exceptions in the Java language.
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Calling: " + methodName);
        // Returns the current time in milliseconds.
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed(); // run the actual method
        long duration = System.currentTimeMillis() - start;

        System.out.println("Finished: " + methodName + " (" + duration + "ms)");
        return result;
    }
}
