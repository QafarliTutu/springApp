package com.testApp.springApp.controller;

import com.testApp.springApp.dto.EducationDto;
import com.testApp.springApp.model.Education;
import com.testApp.springApp.services.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/education")
public class EducationController {

    private final EducationService educationService;

    @PostMapping("create")
    public EducationDto createEducation(@RequestBody EducationDto educationDto){
        return educationService.createEducation(educationDto);
    }

}
