package com.sprint.mission.springdemo;

import java.util.UUID;

public interface UserRepository {
    void save(User user);
    User findById(UUID id);
}
