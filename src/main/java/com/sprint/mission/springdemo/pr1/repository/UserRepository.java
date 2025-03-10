package com.sprint.mission.springdemo.pr1.repository;

import com.sprint.mission.springdemo.pr1.entity.User;

import java.util.UUID;

public interface UserRepository {
    void save(User user);
    User findById(UUID id);
}
