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

    public Education findById(Long id){
        EducationDto educationDto = new EducationDto();
        Optional<Education> byId = educationRepo.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }else throw new EducationNotFoundEx();
    }

}
