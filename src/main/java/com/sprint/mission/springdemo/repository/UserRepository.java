package com.sprint.mission.springdemo.repository;

import com.sprint.mission.springdemo.entity.User;

import java.util.UUID;

public interface UserRepository {
    void save(User user);
    User findById(UUID id);
}
