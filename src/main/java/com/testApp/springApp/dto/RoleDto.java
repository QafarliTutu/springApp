package com.testApp.springApp.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@Validated
public class RoleDto {

    private Long id;

    @NotBlank(message = "Name should not be blank.")
    private String name;

    @NotBlank(message = "Deafult permissions should not be blank.")
    private String defaultPermissions;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    private Boolean status = true;

}
