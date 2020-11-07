package com.testApp.springApp.dto;

import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
public class EducationTrDto {

    private Long id;

    @NotBlank(message = "Name should not be blank.")
    private Map<Integer, String> name;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    @NotBlank(message = "Language should not be blank.")
    private Map<Integer, Long> languageId;

    private Boolean status = true;


}
