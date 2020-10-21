package com.testApp.springApp.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



@Getter
@Setter
@Validated
public class UserDto {

    private Long id;

    @NotBlank
    private Long employeeId;

    @NotBlank
    private String name;

    @NotBlank
    @Size(min = 8)
    private String password;



}
