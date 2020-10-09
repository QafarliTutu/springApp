package com.testApp.springApp.services;


import com.testApp.springApp.enums.RoleEnum;
import com.testApp.springApp.model.Employees;
import com.testApp.springApp.model.Roles;
import com.testApp.springApp.model.Users;
import com.testApp.springApp.model.UsersRoles;
import com.testApp.springApp.repository.EmployeesRepo;
import com.testApp.springApp.repository.RoleRepo;
import com.testApp.springApp.repository.URRepo;
import com.testApp.springApp.repository.UserRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Log4j2
@Service
public class TestService {


    private EmployeesRepo repo;

    private RoleRepo roleRepo;

    private UserRepo userRepo;

    private URRepo urRepo;


    public TestService(EmployeesRepo repo, RoleRepo roleRepo, UserRepo userRepo, URRepo urRepo) {
        this.repo = repo;
        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
        this.urRepo = urRepo;
    }

    public void test(String name) {
        Optional<Employees> byName = repo.findByName(name);
        if (!byName.isEmpty()) {
            Employees employees = byName.get();
            System.out.println(employees);
            Roles roles = Roles.builder()
                    .name("admin")
                    .defaultPermissions("Herseyi gormek")
                    .createdAt(LocalDateTime.now())
                    .build();
            roleRepo.save(roles);
            Optional<Roles> byName1 = roleRepo.findByName("admin");
            if (!byName1.isEmpty()) {
                Roles role_found = byName1.get();
                System.out.println(role_found.toString());
                Users users = Users.builder()
                        .employees(employees)
                        .password("808")
                        .permissions(roles.getDefaultPermissions())
                        .build();
                userRepo.save(users);
                System.out.println("User saved");
                UsersRoles users_roles = UsersRoles.builder()
                        .roles(roles)
                        .users(users)
                        .build();
                urRepo.save(users_roles);

            } else {
                System.out.println("Cannot find Role!");
            }
        } else {
            System.out.println("NICAAAAAAT TAPILMADI!!!!!!!!!!!!");
        }
    }

    public void find(long id) {
        Optional<UsersRoles> byId = urRepo.findById(id);
        if (!byId.isEmpty()) {
            UsersRoles usersRoles = byId.get();
            System.out.println(usersRoles.getRoles().toString());
            System.out.println(usersRoles.getUsers().toString());
        } else {
            System.out.println("taoa bilmedim");
        }
    }
}