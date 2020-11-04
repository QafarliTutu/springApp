package com.testApp.springApp.controller;

import com.testApp.springApp.dto.EducationTrDto;
import com.testApp.springApp.services.EducationTrService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/educationTr")
@RequiredArgsConstructor
public class EducationTrController {

    private final EducationTrService educationTrService;

    @PostMapping("create")
    public EducationTrDto createEducationTr(@RequestBody EducationTrDto educationTrDto){
        return educationTrService.createEducationTr(educationTrDto);
    }


    @PutMapping("update/{id}")
    public EducationTrDto updateEducationTr(@PathVariable("id") Long id ,
                                            @RequestBody EducationTrDto educationTrDto){
        return educationTrService.updateEducationTr(id,educationTrDto);
    }


}
