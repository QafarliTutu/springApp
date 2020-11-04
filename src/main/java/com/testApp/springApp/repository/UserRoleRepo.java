package com.testApp.springApp.repository;

import com.testApp.springApp.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole,List<Long>> {

    UserRole findByUserId(Long id);
    boolean existsByUserId(Long id);
}
