package com.sprint.mission.springdemo.pr1.entity;

import java.util.UUID;

public record User (
        UUID id,
        String name,
        String password
){
}
