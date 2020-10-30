package com.testApp.springApp.controller;

import com.testApp.springApp.dto.LanguageDto;
import com.testApp.springApp.services.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/language")
public class LanguageController {

    private final LanguageService languageService;

    @GetMapping("find/{id}")
    public LanguageDto findById(@PathVariable("id") Long id){
        return languageService.findById(id);
    }


    @PostMapping("create")
    public LanguageDto createLanguage(@RequestBody LanguageDto languageDto){
        return languageService.createLanguage(languageDto);
    }

    @PutMapping("update/{id}")
    public LanguageDto updateLanguage(@PathVariable("id") Long id,@RequestBody LanguageDto languageDto){
        return languageService.updateLanguage(id,languageDto);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable("id") Long id){
        languageService.deleteById(id);
    }
}
