package com.sprint.mission.springdemo.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventNotifier {

    @EventListener // userEvent가 발행됐을 때, 스프링이 이 메소드를 호출할 것
    public void handleUserEvent1(UserEvent userEvent) {
        System.out.println("User event received 1: " + userEvent.getEventType());
    }

    @EventListener // userEvent가 발행됐을 때, 스프링이 이 메소드를 호출할 것
    public void handleUserEvent2(UserEvent userEvent) {
        System.out.println("User event received 2: " + userEvent.getEventType());
    }
}
