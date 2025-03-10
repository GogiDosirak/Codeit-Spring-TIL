package com.sprint.mission.springdemo.controller;

import com.sprint.mission.springdemo.entity.User;
import com.sprint.mission.springdemo.dto.UserCreateDTO;
import com.sprint.mission.springdemo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 요청을 처리하기 때문에 handler라고 부름
    @PostMapping
    public ResponseEntity<UUID> registerUser(@RequestBody UserCreateDTO userCreateDTO) {
        return ResponseEntity.ok(userService.registerUser(userCreateDTO.name()));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        UUID id = UUID.fromString(userId);
        return ResponseEntity.ok(userService.getUser(id));
    }
}
