package com.testApp.springApp.services;


import com.testApp.springApp.dto.EmployeeDto;
import com.testApp.springApp.dto.UserDto;
import com.testApp.springApp.exceptions.EmployeeNotFoundEx;
import com.testApp.springApp.exceptions.UserNotFoundEx;
import com.testApp.springApp.model.Employee;
import com.testApp.springApp.model.Users;

import com.testApp.springApp.repository.EmployeesRepo;
import com.testApp.springApp.repository.RoleRepo;
import com.testApp.springApp.repository.URRepo;
import com.testApp.springApp.repository.UserRepo;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
public class UserService {


    private final EmployeeService employeeService;

    private final RoleRepo roleRepo;

    private final UserRepo userRepo;

    private final URRepo urRepo;


    public UserService(EmployeesRepo employeesRepo, EmployeeService employeeService, RoleRepo roleRepo, UserRepo userRepo, URRepo urRepo) {
        this.employeeService = employeeService;
        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
        this.urRepo = urRepo;
    }

    public UserDto createUser(UserDto userDto){
        EmployeeDto employeeDto = employeeService.findById(userDto.getEmployeeId());
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        Users user = new Users();
        BeanUtils.copyProperties(userDto,user);
        user.setEmployee(employee);
        userRepo.save(user);
        BeanUtils.copyProperties(user,userDto);
        return userDto;
    }

    public UserDto findById(Long id) {
        UserDto userDto = new UserDto();
        Optional<Users> byId = userRepo.findById(id);
        if (byId.isPresent()) {
            BeanUtils.copyProperties(byId.get(), userDto);
            return userDto;
        } else throw new UserNotFoundEx();

    }

//    public UserDto updateUser(Long id, UserDto userDto){
//        Users users = new Users();
//        users.setId(id);
//
//        BeanUtils.copyProperties(employeeDto,employee);
//        employeesRepo.save(employee);
//        BeanUtils.copyProperties(employee,employeeDto);
//        return employeeDto;
//    }


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