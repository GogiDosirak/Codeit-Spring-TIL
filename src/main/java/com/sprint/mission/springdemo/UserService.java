package com.sprint.mission.springdemo;

import java.util.UUID;

public interface UserService {
    UUID registerUser(String userName);
    User getUser(UUID userId);
}
