package com.testApp.springApp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UsersRolesDto {

    private Long id;

   // @NotBlank(message = "Permissions required!")
    private String permissions;

    @NotBlank(message = "Roles required!")
    private Long rolesId;

    @NotBlank(message = "Select any User!")
    private Long usersId;

}
