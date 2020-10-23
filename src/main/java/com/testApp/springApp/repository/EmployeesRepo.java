package com.testApp.springApp.repository;


import com.testApp.springApp.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeesRepo extends JPA<Employee> {


}
