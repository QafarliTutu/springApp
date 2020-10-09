package com.testApp.springApp.repository;


import com.testApp.springApp.model.Employees;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeesRepo extends JpaRepository<Employees,Long>{
    Optional<Employees> findByName(String name);
}
