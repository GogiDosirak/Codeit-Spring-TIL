package com.sprint.mission.springdemo.pr1.component;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class SingletonComponent {

    private int randomInt;

    public SingletonComponent() {
        System.out.println("SingletonComponent constructor");
    }

    @PostConstruct
    public void init() {
        randomInt = (int) (Math.random() * 100);
    }

    public int getRandomInt() {
        return randomInt;
    }
}
