package com.testApp.springApp.services;


import com.testApp.springApp.model.Education;
import com.testApp.springApp.model.Employees;
import com.testApp.springApp.payload.request.EmployeeRegisterRequest;
import com.testApp.springApp.payload.response.MessageResponse;
import com.testApp.springApp.repository.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
public class EmpService {


    private final EmployeesRepo employeesRepo;

    private final RoleRepo roleRepo;

    private final UserRepo userRepo;

    private final URRepo urRepo;

    private final EducationRepo eduRepo;


    public EmpService(EmployeesRepo employeesRepo, RoleRepo roleRepo, UserRepo userRepo, URRepo urRepo, EducationRepo eduRepo) {
        this.employeesRepo = employeesRepo;
        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
        this.urRepo = urRepo;
        this.eduRepo = eduRepo;
    }



    public ResponseEntity<?> EmpRegister(EmployeeRegisterRequest regRequest) {
        if(employeesRepo.existsByEmail(regRequest.getEmail())){
            return ResponseEntity.badRequest().body(new MessageResponse(false,1L,"ERROR: Email already exists!"));
        }
        if(employeesRepo.existsByContact(regRequest.getContact())){
            return ResponseEntity.badRequest().body(new MessageResponse(false,2L,"ERROR: Contact already exists!"));
        }
        Optional<Education> byId = eduRepo.findById(regRequest.getEducationId());
        if(byId.isPresent()) {
            Employees employee = Employees.builder()
                    .name(regRequest.getName())
                    .surname(regRequest.getSurname())
                    .email(regRequest.getEmail())
                    .address(regRequest.getAddress())
                    .birthdate(regRequest.getBirthdate())
                    .image(regRequest.getImage())
                    .contact(regRequest.getContact())
                    .educationId(byId.get())
                    .build();
            employeesRepo.save(employee);
            return ResponseEntity.ok().body(new MessageResponse(true, 3L, "SUCCESS: Employee successfully registered!"));
        } else return ResponseEntity.badRequest().body(new MessageResponse(false,6L,"ERROR: Education not found!"));

    }
}