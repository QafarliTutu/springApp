package com.testApp.springApp.payload.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@Validated
public class UserRegisterRequest {

    @NotBlank
    private String name;

    @NotBlank
    @Size(min = 8)
    private String password;

    @NotBlank
    private Set<String> roleName;

}
