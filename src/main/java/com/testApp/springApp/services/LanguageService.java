package com.testApp.springApp.services;

import com.testApp.springApp.dto.LanguageDto;
import com.testApp.springApp.exceptions.LanguageAlreadyExistsEx;
import com.testApp.springApp.exceptions.LanguageNotFoundEx;
import com.testApp.springApp.model.Education;
import com.testApp.springApp.model.Language;
import com.testApp.springApp.repository.LanguageRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LanguageService {

    private final LanguageRepo languageRepo;

    public LanguageService(LanguageRepo languageRepo) {
        this.languageRepo = languageRepo;
    }

    public LanguageDto createLanguage(LanguageDto languageDto) {
        boolean existsByName = languageRepo.existsByName(languageDto.getName());
        if (!existsByName) {
            Language language = new Language();
            BeanUtils.copyProperties(languageDto, language);
            languageRepo.save(language);
            BeanUtils.copyProperties(language, languageDto);
            return languageDto;
        } else throw new LanguageAlreadyExistsEx();
    }

    public LanguageDto findById(Long id) {
        Optional<Language> byId = languageRepo.findById(id);
        if (byId.isPresent()) {
            LanguageDto languageDto = new LanguageDto();
            BeanUtils.copyProperties(byId.get(), languageDto);
            return languageDto;
        }else throw new LanguageNotFoundEx();
    }

    public LanguageDto updateLanguage(Long id, LanguageDto languageDto) {
        Optional<Language> byId = languageRepo.findById(id);
        if (byId.isPresent()) {
            Language language = byId.get();
            BeanUtils.copyProperties(languageDto, language);
            language.setId(id);
            languageRepo.save(language);
            BeanUtils.copyProperties(language, languageDto);
            return languageDto;
        }else throw new LanguageNotFoundEx();
    }

    public void deleteById(Long id) {
        //languageRepo.deleteById(id);
        Optional<Language> byId = languageRepo.findById(id);
        if(byId.isPresent() && byId.get().getStatus()){
            Language language = byId.get();
            language.setStatus(false);
            language.setDeletedAt(LocalDateTime.now());
            languageRepo.save(language);
        }
    }
}
