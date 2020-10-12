package com.testApp.springApp.payload.request;

import com.sun.istack.NotNull;
import com.testApp.springApp.model.Education;
import lombok.Getter;
import lombok.Setter;

import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Validated
public class EmployeeRegisterRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String image;

//    @Column(name = "password")
//    private String password;

    @NotBlank
    private String address;

    @NotBlank
    @Size(min = 9)
    private String contact;

    @NotBlank
    @Size(min = 8)
    private String birthdate;

    @NotBlank
    private long educationId;
}
