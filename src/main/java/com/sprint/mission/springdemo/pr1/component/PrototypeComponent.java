package com.sprint.mission.springdemo.pr1.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeComponent {
    private final int randomInt;

    public PrototypeComponent() {
        randomInt = (int) (Math.random() * 100);
    }

    public int getRandomInt() {
        return randomInt;
    }
}
