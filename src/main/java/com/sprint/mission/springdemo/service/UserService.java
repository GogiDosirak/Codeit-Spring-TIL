package com.sprint.mission.springdemo.service;

import com.sprint.mission.springdemo.entity.User;

import java.util.UUID;

public interface UserService {
    UUID registerUser(String userName);
    User getUser(UUID userId);
}
