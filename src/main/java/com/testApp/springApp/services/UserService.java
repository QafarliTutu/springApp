package com.testApp.springApp.services;


import com.testApp.springApp.dto.UserDto;
import com.testApp.springApp.exceptions.EmployeeNotFoundEx;
import com.testApp.springApp.model.Employee;
import com.testApp.springApp.model.Users;

import com.testApp.springApp.repository.EmployeesRepo;
import com.testApp.springApp.repository.RoleRepo;
import com.testApp.springApp.repository.URRepo;
import com.testApp.springApp.repository.UserRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public UserDto createUser(UserDto userDto){
        Optional<Employee> byId = employeesRepo.findById(userDto.getId());
        if (byId.isEmpty()){
            throw new EmployeeNotFoundEx();
        }
        Users user = new Users();
        BeanUtils.copyProperties(userDto,user);
        user.setEmployee(byId.get());
        userRepo.save(user);
        BeanUtils.copyProperties(user,userDto);
        return userDto;
    }


//    public ResponseEntity<?> UserRegister(UserDto regRequest) {
//        Set<Roles> roles = new HashSet<>();
//        Optional<Employee> byNameEmp = employeesRepo.findByName(regRequest.getName());
//        if(byNameEmp.isPresent()){
//            regRequest.getRoleName().forEach(role ->{
//                Optional<Roles> byNameRole = roleRepo.findByName(role);
//                byNameRole.ifPresent(roles::add);
//            });
//            Users user = Users.builder()
//                    .employee(byNameEmp.get())
//                    .password(regRequest.getPassword())
//                    .build();
//            roles.forEach(role ->{
//                UsersRoles usersRoles = UsersRoles.builder()
//                        .roles(role)
//                        .users(user)
//                        .permissions(role.getDefaultPermissions())
//                        .build();
//                urRepo.save(usersRoles);
//            });
//
//            return ResponseEntity.ok().body(new MessageResponse(true,4L,"SUCCESS: User successfully registered!"));
//        }else return ResponseEntity.ok().body(new MessageResponse(false,5L,"ERROR: Employee not found!"));
//    }
}