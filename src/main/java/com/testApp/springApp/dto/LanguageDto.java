package com.testApp.springApp.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Validated
public class LanguageDto {

    private Long id;

    @NotBlank(message = "Name should not be blank.")
    private String name;

    @NotBlank(message = "Code should not be blank.")
    private String code;

    private Boolean isVisible;

}
