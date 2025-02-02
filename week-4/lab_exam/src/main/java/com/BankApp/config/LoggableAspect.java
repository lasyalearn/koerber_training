package com.BankApp.config;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggableAspect
{
    @Around("@annotation(com.BankApp.config.Loggable)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable
    {
        Logger logger = org.slf4j.LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        logger.info("Executing method: {}", joinPoint.getSignature().getName());
        long startTime = System.currentTimeMillis();
        Object result=joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("*****************************************************************************");
        logger.info("Execution time: {} ms", endTime - startTime);
        return result;
    }
}
