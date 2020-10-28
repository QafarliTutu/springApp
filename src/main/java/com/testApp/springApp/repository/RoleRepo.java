package com.testApp.springApp.repository;

import com.testApp.springApp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
    boolean existByName(String name);
}
