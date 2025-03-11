package com.sprint.mission.springdemo.pr1.logging;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(1)
public class ServiceLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(ServiceLoggingAspect.class); // 로그를 레벨별로 나눠서 출력 가능

    @Around("@annotation(com.sprint.mission.springdemo.pr1.logging.ServiceLogging)")
    public Object loggingResult(ProceedingJoinPoint joinPoint) throws Throwable {
        // before
        String methodName = joinPoint.getSignature().toShortString();
        logger.info(methodName + " 메소드 실행. 인자값 : " + joinPoint.getArgs()[0]);
        Object result = joinPoint.proceed();
        // after
        logger.info(methodName + " 메소드 결과값 : " + result);
        return result;
    }

}
