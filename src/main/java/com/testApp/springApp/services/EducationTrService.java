package com.testApp.springApp.services;

import com.testApp.springApp.dto.EducationDto;
import com.testApp.springApp.dto.EducationTrDto;
import com.testApp.springApp.dto.LanguageDto;
import com.testApp.springApp.model.Education;
import com.testApp.springApp.model.EducationTr;
import com.testApp.springApp.model.Language;
import com.testApp.springApp.repository.EducationTrRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EducationTrService {

    private final EducationTrRepo educationTrRepo;
    private final LanguageService languageService;
    private final EducationService educationService;

    public EducationTrService(EducationTrRepo educationTrRepo, LanguageService languageService, EducationService educationService) {
        this.educationTrRepo = educationTrRepo;
        this.languageService = languageService;
        this.educationService = educationService;
    }

    public EducationTrDto createEducationTr(EducationTrDto educationTrDto) {
        Language language = new Language();
        LanguageDto languageDto = languageService.findById(educationTrDto.getLanguageId());
        BeanUtils.copyProperties(languageDto,language);

        Education education = new Education();
        EducationDto educationDto = educationService.findById(educationTrDto.getEducationId());
        BeanUtils.copyProperties(educationDto, education);

        EducationTr educationTr = new EducationTr();
        BeanUtils.copyProperties(educationTrDto,educationTr);
        educationTr.setEducationId(education);
        educationTr.setLanguage(language);
        educationTrRepo.save(educationTr);
        BeanUtils.copyProperties(educationTr, educationTrDto);
        return educationTrDto;
    }

}
