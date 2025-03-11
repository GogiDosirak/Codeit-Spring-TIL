package com.sprint.mission.springdemo.pr1.cache;

import com.sprint.mission.springdemo.pr1.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
@Order(2)
public class ServiceCacheAspect {

    private final Map<String, Object> cache = new ConcurrentHashMap<>();

    @Around("@annotation(com.sprint.mission.springdemo.pr1.cache.ServiceCache)") // ServiceCache라는 어노테이션이 달려있는 메소드에만 Aspect 적용
    public Object cacheResult(ProceedingJoinPoint joinPoint) throws  Throwable {
        String cacheKey = generateKey(joinPoint);

        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }

        Object result = joinPoint.proceed();

        cache.put(cacheKey, result);
        return result;
    }

    // 캐시의 키값을 직접 생성 - 같은 메소드가 같은 인자를 가지면 같은 키값을 가지도록!
    private String generateKey(ProceedingJoinPoint joinPoint) {
        StringBuilder key = new StringBuilder();
        key.append(joinPoint.getSignature().toShortString()); // 메소드 이름을 받아와서 문자열로 바꾸기
        for (Object arg : joinPoint.getArgs()) {
            key.append("-").append(arg.toString()); // 호출하는 인자들도 하나씩 다 붙여줌
        }
        return key.toString();
    }
}
