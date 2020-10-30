package com.testApp.springApp.repository;

import com.testApp.springApp.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepo extends JpaRepository<Language,Long> {
    boolean existsByName(String name);
}
