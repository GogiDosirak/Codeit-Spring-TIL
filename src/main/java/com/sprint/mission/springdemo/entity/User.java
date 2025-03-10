package com.sprint.mission.springdemo.entity;

import java.util.UUID;

public record User (
        UUID id,
        String name
){
}
