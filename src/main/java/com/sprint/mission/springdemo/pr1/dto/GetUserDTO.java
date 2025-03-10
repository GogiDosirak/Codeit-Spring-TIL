package com.sprint.mission.springdemo.pr1.dto;

import java.util.UUID;

public record GetUserDTO(
        UUID id,
        String username
) {
}
