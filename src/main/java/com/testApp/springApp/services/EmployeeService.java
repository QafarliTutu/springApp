package com.testApp.springApp.services;


import com.testApp.springApp.dto.EducationDto;
import com.testApp.springApp.exceptions.EmployeeAlreadyExistEx;
import com.testApp.springApp.exceptions.EmployeeNotFoundEx;
import com.testApp.springApp.model.Education;
import com.testApp.springApp.model.Employee;
import com.testApp.springApp.dto.EmployeeDto;
import com.testApp.springApp.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class EmployeeService {


    private final EmployeesRepo employeesRepo;

    private final EducationService educationService;



    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        boolean existByEmail = employeesRepo.existsByEmail(employeeDto.getEmail());
        if(!existByEmail){
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            Education education = new Education();
            EducationDto educationDto = educationService.findById(employeeDto.getEducationId());
            BeanUtils.copyProperties(educationDto, education);
            employee.setEducation(education);
            employeesRepo.save(employee);
            BeanUtils.copyProperties(employee, employeeDto);
            return employeeDto;
        }else throw new EmployeeAlreadyExistEx();
    }

    public EmployeeDto findById(Long id) {
        EmployeeDto employeeDto = new EmployeeDto();
        Optional<Employee> byId = employeesRepo.findById(id);
        if (byId.isPresent()) {
            BeanUtils.copyProperties(byId.get(), employeeDto);
            return employeeDto;
        } else throw new EmployeeNotFoundEx();

    }

    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setId(id);
        BeanUtils.copyProperties(employeeDto,employee);
        employeesRepo.save(employee);
        BeanUtils.copyProperties(employee,employeeDto);
        return employeeDto;
    }

    public void deleteEmployee(Long id){
        employeesRepo.deleteById(id);
    }


}