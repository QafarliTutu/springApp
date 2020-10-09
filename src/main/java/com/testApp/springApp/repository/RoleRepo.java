package com.testApp.springApp.repository;

import com.testApp.springApp.enums.RoleEnum;
import com.testApp.springApp.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Roles,Long> {
    Optional<Roles> findByName(String name);

}
