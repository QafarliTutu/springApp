package com.testApp.springApp.repository;

import com.testApp.springApp.model.EducationTr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationTrRepo extends JpaRepository<EducationTr, Long> {

}
