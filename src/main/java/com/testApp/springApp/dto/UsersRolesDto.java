package com.testApp.springApp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class UsersRolesDto {

    private Long id;

    private Map<Long, String> permissions;

    @NotBlank(message = "Roles required!")
    private List<Long> rolesId;

    @NotBlank(message = "Select any User!")
    private Long usersId;

}
