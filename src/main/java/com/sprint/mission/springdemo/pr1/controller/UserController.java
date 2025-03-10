package com.sprint.mission.springdemo.pr1.controller;

import com.sprint.mission.springdemo.pr1.dto.GetUserDTO;
import com.sprint.mission.springdemo.pr1.entity.User;
import com.sprint.mission.springdemo.pr1.dto.UserCreateDTO;
import com.sprint.mission.springdemo.pr1.service.UserService;
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
        return ResponseEntity.ok(userService.registerUser(userCreateDTO.name(), userCreateDTO.password()));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<GetUserDTO> getUser(@PathVariable String userId) {
        UUID id = UUID.fromString(userId);
        User user = userService.getUser(id);
        return ResponseEntity.ok(userEntityToDTO(user));

    }

    private GetUserDTO userEntityToDTO(User user) {
        return new GetUserDTO(user.id(), user.name());
    }
}
