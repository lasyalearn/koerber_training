package com.keorber.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
@Aspect
public class LoggingAspect
{
    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    @Around("@annotation(com.keorber.service.Loggable)")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        logger.info("Before " + proceedingJoinPoint.getSignature().getName());
        Object result = proceedingJoinPoint.proceed();
        logger.info("After " + proceedingJoinPoint.getSignature().getName());
        return result;
    }
}
