package com.sprint.mission.springdemo;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventListener {

    @EventListener // userEvent가 발행됐을 때, 스프링이 이 메소드를 호출할 것
    public void handleUserEvent(UserEvent userEvent) {
        System.out.println("User event received: " + userEvent.getEventType());
    }
}
