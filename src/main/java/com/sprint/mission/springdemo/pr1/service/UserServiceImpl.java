package com.sprint.mission.springdemo.pr1.service;

import com.sprint.mission.springdemo.pr1.cache.ServiceCache;
import com.sprint.mission.springdemo.pr1.entity.User;
import com.sprint.mission.springdemo.pr1.event.UserEvent;
import com.sprint.mission.springdemo.pr1.event.UserEventType;
import com.sprint.mission.springdemo.pr1.logging.ServiceLogging;
import com.sprint.mission.springdemo.pr1.repository.UserRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ApplicationEventPublisher eventPublisher; // User가 생성됐을 때 이벤트를 반환하기 위해 필요

    // 생성자 주입
    public UserServiceImpl(UserRepository userRepository, ApplicationEventPublisher eventPublisher) {
        this.userRepository = userRepository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    @ServiceLogging
    public UUID registerUser(String userName, String password) {
        User user = new User(UUID.randomUUID(), userName, password);
        userRepository.save(user);
        UserEvent event = new UserEvent(this, UserEventType.REGISTERED, "User registerd: " + userName);
        eventPublisher.publishEvent(event);
        return user.id();
    }

    @Override
    @ServiceCache
    @ServiceLogging  // 캐싱이 된 상태라면, joinPoint.proceed()가 실행이 안되므로 ServiceLogging도 실행 X
    public User getUser(UUID userId) {
        return userRepository.findById(userId);
    }
}
