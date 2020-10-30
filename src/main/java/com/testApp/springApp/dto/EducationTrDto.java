package com.testApp.springApp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
public class EducationTrDto {

    private Long id;

    @NotBlank(message = "Name should not be blank.")
    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @NotBlank(message = "Language should not be blank.")
    private Long languageId;

//    @NotBlank(message = "Education should not be blank.")
    private Long educationId;
}
