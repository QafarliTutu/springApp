package com.testApp.springApp.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class EducationDto {

    private Long id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


}
