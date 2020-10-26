package com.testApp.springApp.repository;

import com.testApp.springApp.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EducationRepo extends JpaRepository<Education,Long> {

    Optional<Education> findById(long id);
}
