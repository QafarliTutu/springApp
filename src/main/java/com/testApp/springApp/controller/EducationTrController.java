package com.testApp.springApp.controller;

import com.testApp.springApp.dto.EducationTrDto;
import com.testApp.springApp.services.EducationTrService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/educationTr")
@RequiredArgsConstructor
public class EducationTrController {

    private final EducationTrService educationTrService;

    @PostMapping("create")
    public EducationTrDto createEducationTr(@RequestBody EducationTrDto educationTrDto){
        return educationTrService.createEducationTr(educationTrDto);
    }


}
