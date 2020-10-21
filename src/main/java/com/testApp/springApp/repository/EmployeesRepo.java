package com.testApp.springApp.repository;


import com.testApp.springApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeesRepo extends JpaRepository<Employee,Long>{
    Optional<Employee> findByName(String name);
    Optional<Employee> findByEmail(String name);

    boolean existsByEmail(String email);
    boolean existsByContact(String contact);

}
