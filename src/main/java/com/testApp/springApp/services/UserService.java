package com.testApp.springApp.services;


import com.testApp.springApp.model.Employees;
import com.testApp.springApp.model.Roles;
import com.testApp.springApp.model.Users;
import com.testApp.springApp.model.UsersRoles;
import com.testApp.springApp.payload.request.EmployeeRegisterRequest;
import com.testApp.springApp.payload.request.UserRegisterRequest;
import com.testApp.springApp.payload.response.MessageResponse;
import com.testApp.springApp.repository.EmployeesRepo;
import com.testApp.springApp.repository.RoleRepo;
import com.testApp.springApp.repository.URRepo;
import com.testApp.springApp.repository.UserRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Log4j2
@Service
public class UserService {


    private final EmployeesRepo employeesRepo;

    private final RoleRepo roleRepo;

    private final UserRepo userRepo;

    private final URRepo urRepo;


    public UserService(EmployeesRepo employeesRepo, RoleRepo roleRepo, UserRepo userRepo, URRepo urRepo) {
        this.employeesRepo = employeesRepo;
        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
        this.urRepo = urRepo;
    }



    public ResponseEntity<?> UserRegister(UserRegisterRequest regRequest) {
        Set<Roles> roles = new HashSet<>();
        Optional<Employees> byNameEmp = employeesRepo.findByName(regRequest.getName());
        if(byNameEmp.isPresent()){
            regRequest.getRoleName().forEach(role ->{
                Optional<Roles> byNameRole = roleRepo.findByName(role);
                byNameRole.ifPresent(roles::add);
            });
            Users user = Users.builder()
                    .employees(byNameEmp.get())
                    .password(regRequest.getPassword())
                    .build();
            roles.forEach(role ->{
                UsersRoles usersRoles = UsersRoles.builder()
                        .roles(role)
                        .users(user)
                        .permissions(role.getDefaultPermissions())
                        .build();
                urRepo.save(usersRoles);
            });
            return ResponseEntity.ok().body(new MessageResponse(true,4L,"SUCCESS: User successfully registered!"));
        }else return ResponseEntity.ok().body(new MessageResponse(false,5L,"ERROR: Employee not found!"));
    }
}