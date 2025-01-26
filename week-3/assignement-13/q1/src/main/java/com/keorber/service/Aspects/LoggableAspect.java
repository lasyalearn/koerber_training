package com.keorber.service.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
class LoggableAspect
{
    private static final Logger logger = LoggerFactory.getLogger(LoggableAspect.class);
    @Around("@annotation(com.keorber.service.Aspects.Loggable)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable
    {
        logger.info("Method {} called", joinPoint.getSignature().getName());
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long end = System.currentTimeMillis();
        logger.info("Method {} took {} ms", joinPoint.getSignature().getName(), end - start);
        return proceed;

    }
}


