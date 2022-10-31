package com.dzhenetl.transferapp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggerAspect {

    private final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    @Around("execution(* com.dzhenetl.transferapp.controller.TransferController.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("execution " + joinPoint.getSignature().getName() + " with args " + Arrays.toString(joinPoint.getArgs()));
        return joinPoint.proceed();
    }
}
