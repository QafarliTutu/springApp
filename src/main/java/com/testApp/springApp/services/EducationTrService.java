package com.testApp.springApp.services;

import com.testApp.springApp.dto.EducationDto;
import com.testApp.springApp.dto.EducationTrDto;
import com.testApp.springApp.dto.LanguageDto;
import com.testApp.springApp.model.Education;
import com.testApp.springApp.model.EducationTr;
import com.testApp.springApp.model.Language;
import com.testApp.springApp.repository.EducationTrRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EducationTrService {

    private final EducationTrRepo educationTrRepo;
    private final LanguageService languageService;
    private final EducationService educationService;

    public EducationTrDto createEducationTr(EducationTrDto educationTrDto) {

        Education education = new Education();
        EducationDto existingEducationDto = educationService.createEducation(new EducationDto());
        BeanUtils.copyProperties(existingEducationDto, education);

        educationTrDto.getLanguageId()
                .keySet()
                .forEach(integer -> {
                    EducationTr educationTr = new EducationTr();
                    String educationName = educationTrDto.getName().get(integer);
                    Language language = new Language();
                    LanguageDto languageDto = languageService.findById(educationTrDto.getLanguageId().get(integer));
                    BeanUtils.copyProperties(languageDto, language);
                    educationTr.setLanguage(language);
                    educationTr.setName(educationName);
                    educationTr.setEducation(education);
                    educationTrRepo.save(educationTr);
                    BeanUtils.copyProperties(educationTr, educationTrDto);

                });
        return educationTrDto;

    }

    public EducationTrDto updateEducationTr(Long id, EducationTrDto educationTrDto) {


        return null;
    }
}
