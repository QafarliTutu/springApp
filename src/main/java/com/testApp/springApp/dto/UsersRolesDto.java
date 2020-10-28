package com.testApp.springApp.dto;

import javax.validation.constraints.NotBlank;

public class UsersRolesDto {

    private Long id;

    @NotBlank(message = "permissions required!")
    private String permissions;

    @NotBlank(message = "Roles required")
    private Long rolesId;

    @NotBlank(message = "Select any User!")
    private Long usersId;

}
