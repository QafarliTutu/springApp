package com.testApp.springApp.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class EducationTrDto {

    private Long id;

    @NotBlank(message = "Name should not be blank.")
    private Map<Integer, String> name;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @NotBlank(message = "Language should not be blank.")
    private Map<Integer, Long> languageId;

    //    @NotBlank(message = "Education should not be blank.")
    //private Long educationId;
}
