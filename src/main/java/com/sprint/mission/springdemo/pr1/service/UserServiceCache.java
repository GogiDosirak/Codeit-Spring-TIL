package com.sprint.mission.springdemo.pr1.service;

import com.sprint.mission.springdemo.pr1.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class UserServiceCache {

    private final Map<UUID, User> cache = new ConcurrentHashMap<>();

    @Around("execution(* com.sprint.mission.springdemo.pr1.service.UserServiceImpl.getUser(..))")
    public User chcheUser(ProceedingJoinPoint joinPoint) throws  Throwable {
        // 메소드 호출 파라미터 가져오기
        Object[] args = joinPoint.getArgs();
        UUID userId = (UUID) args[0];
        if (cache.containsKey(userId)) {
            System.out.println("Cache hit");
            return cache.get(userId); //cache에 있다면 반환
        }
        Object result = joinPoint.proceed(args); // 아니라면 joinPoint를 실행 (getUser 메소드 실행)
        User user = (User) result;
        cache.put(userId, user); // 캐시에 넣고
        return user;
    }
}
