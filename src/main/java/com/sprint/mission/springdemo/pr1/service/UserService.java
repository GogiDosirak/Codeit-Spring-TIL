package com.sprint.mission.springdemo.pr1.service;

import com.sprint.mission.springdemo.pr1.entity.User;

import java.util.UUID;

public interface UserService {
    UUID registerUser(String userName, String password);
    User getUser(UUID userId);
}
