package com.testApp.springApp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserRoleDto {

    private Long id;

   // @NotBlank(message = "Permissions required!")
    private String permissions;

    @NotBlank(message = "Roles required!")
    private Long roleId;

    @NotBlank(message = "Select any User!")
    private Long userId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;
}
