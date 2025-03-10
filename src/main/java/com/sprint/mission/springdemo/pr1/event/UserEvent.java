package com.sprint.mission.springdemo.pr1.event;

import org.springframework.context.ApplicationEvent;

public class UserEvent extends ApplicationEvent {

    private final UserEventType eventType;
    private final String message;

    public UserEvent(Object source, UserEventType eventType, String message) {
        super(source);
        this.eventType = eventType;
        this.message = message;
    }

    public UserEventType getEventType() {
        return eventType;
    }

    public String getMessage() {
        return message;
    }
}
