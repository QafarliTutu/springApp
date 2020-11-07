package com.testApp.springApp.dto;

import lombok.Getter;
import lombok.Setter;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@Validated
public class EmployeeDto {

    private Long id;

    @NotBlank(message = "Name should not be blank.")
    private String name;

    @NotBlank(message = "Surname should not be blank.")
    private String surname;

    @NotBlank(message ="Email should not be blank.")
    @Email(message = "Email format required.")
    private String email;

    @NotBlank(message = "Image should not be blank.")
    private String image;

    @NotBlank(message = "Address should not be blank.")
    private String address;

    @NotBlank(message = "Contact should not be blank.")
    @Size(min = 9,message = "Contact should be at least 9 number.")
    private String contact;

    @NotBlank(message = "Birthdate should not be blank.")
    @Size(min = 8,message = "Birthdate should be at least 9 number.")
    private String birthdate;

    @NotBlank(message = "Education should not be blank.")
    private Long educationId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    private Boolean status = true;

}
