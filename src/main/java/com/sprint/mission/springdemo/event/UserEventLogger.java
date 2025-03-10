package com.sprint.mission.springdemo.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventLogger {


    @EventListener // userEvent가 발행됐을 때, 스프링이 이 메소드를 호출할 것
    public void sendUserEventLog(UserEvent userEvent) {
        System.out.println("send user event log to timeseries DB: " + userEvent.getEventType());
    }
}
