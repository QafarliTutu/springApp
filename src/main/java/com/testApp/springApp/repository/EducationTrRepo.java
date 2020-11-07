package com.testApp.springApp.repository;

import com.testApp.springApp.model.Education;
import com.testApp.springApp.model.EducationTr;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EducationTrRepo extends JpaRepository<EducationTr, Long> {

    List<EducationTr> findAllByEducationId(Long id);

    Optional<EducationTr> findByEducationIdAndLanguageId(Long eId, Long lId);

//    @Modifying
//    @Query(value = "UPDATE education_tr SET status = false  WHERE education_id=(select education_id from education where education_id=1)", nativeQuery = true)
//    Optional<EducationTr> setStatusFalseByEducationId(@Param("id")Long id);

    void setStatusFalseByEducationTrId(Long id);
}
