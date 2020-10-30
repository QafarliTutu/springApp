package com.testApp.springApp.services;

import com.testApp.springApp.dto.EducationDto;
import com.testApp.springApp.exceptions.EducationNotFoundEx;
import com.testApp.springApp.model.Education;
import com.testApp.springApp.repository.EducationRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EducationService {

    private final EducationRepo educationRepo;

    public EducationService(EducationRepo educationRepo) {
        this.educationRepo = educationRepo;
    }

    public EducationDto findById(Long id) {
        EducationDto educationDto = new EducationDto();
        Optional<Education> byId = educationRepo.findById(id);
        if (byId.isPresent()) {
            BeanUtils.copyProperties(byId.get(), educationDto);
            return educationDto;
        } else throw new EducationNotFoundEx();
    }

//    public EducationDto createEducation(EducationDto educationDto) {
//        Education education = new Education();
//        BeanUtils.copyProperties(educationDto, education);
//        educationRepo.save(education);
//        BeanUtils.copyProperties(education, educationDto);
//        return educationDto;
//    }

    public void deleteEducation(Long id) {
        educationRepo.deleteById(id);
    }
}
