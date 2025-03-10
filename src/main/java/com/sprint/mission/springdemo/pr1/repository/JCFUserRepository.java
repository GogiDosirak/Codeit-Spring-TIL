package com.sprint.mission.springdemo.pr1.repository;

import com.sprint.mission.springdemo.pr1.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class JCFUserRepository implements UserRepository {

    private final Map<UUID, User> users = new ConcurrentHashMap<>();

    public JCFUserRepository() {
        System.out.println("JCFUserRepository created");
    }

    @Override
    public void save(User user) {
        users.put(user.id(), user);

    }

    @Override
    public User findById(UUID id) {
        return users.get(id);
    }
}
