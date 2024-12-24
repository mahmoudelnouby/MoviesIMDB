package com.example.FawryTask.LoggingAspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // Pointcut for all methods in specified packages
//    @Pointcut("execution(* com.example.FawryTask..*(..))")
    @Pointcut("execution(* com.example.FawryTask.service.*.*(..))")
    public void applicationPackagePointcut() {}

    // Log before method execution
//    @Pointcut("execution(* com.example.FawryTask.service.*.*(..))")
//    com/example/FawryTask/Services/FilmsService.java
    @Before("execution(* com.example.FawryTask.Services.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Before Method: {}", joinPoint.getSignature().getName());
        logger.info("Arguments: {}", Arrays.toString(joinPoint.getArgs()));
    }

    // Log after method returns successfully
//    @Pointcut("execution(* com.example.FawryTask.service.*.*(..))")
    @AfterReturning(pointcut = "execution(* com.example.FawryTask.Services.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("After Method: {}", joinPoint.getSignature().getName());
        logger.info("Return Value: {}", result);
    }

    // Log when a method throws an exception
//    @Pointcut("execution(* com.example.FawryTask.service.*.*(..))")
    @AfterThrowing(pointcut = "execution(* com.example.FawryTask.Services.*.*(..))", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        logger.error("Exception in Method: {}", joinPoint.getSignature().getName());
        logger.error("Exception: {}", error.getMessage(), error);
    }
}
