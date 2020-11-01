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

import java.util.Optional;

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
        Education education = new Education();
        boolean ifExistOrNot = educationService.existById(educationTrDto.getEducationId());
        if(!ifExistOrNot){
            EducationDto educationDto1 = new EducationDto();
            EducationDto education1 = educationService.createEducation(educationDto1);
            BeanUtils.copyProperties(education1,education);
        }else{
            EducationDto existingEducationDto = educationService.findById(educationTrDto.getEducationId());
            BeanUtils.copyProperties(existingEducationDto,education);
        }
        Language language = new Language();
        LanguageDto languageDto = languageService.findById(educationTrDto.getLanguageId());
        BeanUtils.copyProperties(languageDto,language);

        EducationTr educationTr = new EducationTr();
        BeanUtils.copyProperties(educationTrDto,educationTr);
        educationTr.setEducation(education);
        educationTr.setLanguage(language);
        educationTrRepo.save(educationTr);
        BeanUtils.copyProperties(educationTr, educationTrDto);
        return educationTrDto;

//        Optional<EducationDto> educationDto = educationService.findById(educationTrDto.getEducationId());
//        Education education = new Education();
//        if(educationDto.isPresent()) {
//            BeanUtils.copyProperties(educationDto, education);
//        }else {
//            EducationDto educationDto1 = new EducationDto();
//            EducationDto education1 = educationService.createEducation(educationDto1);
//            BeanUtils.copyProperties(education1,education);
//        }
    }

    public EducationTrDto updateEducationTr(Long id, EducationTrDto educationTrDto) {
        return null;
    }
}
