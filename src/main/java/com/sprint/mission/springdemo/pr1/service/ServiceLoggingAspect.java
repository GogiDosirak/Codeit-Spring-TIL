package com.sprint.mission.springdemo.pr1.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLoggingAspect {

    @Before("execution(* com.sprint.mission.springdemo.pr1.service.UserServiceImpl.registerUser(..))")
    public void beforeRegisterUser() {
        System.out.println("Before registerUser");

    }
}
