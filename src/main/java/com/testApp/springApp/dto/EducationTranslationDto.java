package com.testApp.springApp.dto;


import com.testApp.springApp.model.Education;
import com.testApp.springApp.model.Language;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class EducationTranslationDto {

    private Long id;

    @NotBlank(message = "Name should not be blank.")
    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @NotBlank(message = "Languagee should not be blank.")
    private Long language;

    @NotBlank(message = "Education should not be blank.")
    private Long educationId;
}
