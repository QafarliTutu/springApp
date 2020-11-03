package com.testApp.springApp.controller;

import com.testApp.springApp.dto.UsersRolesDto;
import com.testApp.springApp.services.UsersRolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth/usersRoles")
@RequiredArgsConstructor
public class UsersRolesController {

    private final UsersRolesService usersRolesService;

    @PostMapping("create")
<<<<<<< HEAD
    public UsersRolesDto createUsersRoles(@RequestBody UsersRolesDto usersRolesDto) {
        return usersRolesService.createUsersRoles(usersRolesDto);
=======
    public UsersRolesDto createOrUpdateUserRole(@RequestBody UsersRolesDto usersRolesDto){
        return usersRolesService.createUserRole(usersRolesDto);
>>>>>>> bbebae0f0b2a38530d713212e9898d6467a9989e
    }

    @GetMapping("find/{id}")
    public UsersRolesDto findById(@PathVariable("id") Long id) {
        return usersRolesService.findById(id);
    }

    @PutMapping("update/{id}")
    public UsersRolesDto updateUsersRoles(@PathVariable("id") Long userId,@RequestBody UsersRolesDto usersRolesDto) {
        return usersRolesService.updateUsersRoles(userId, usersRolesDto);
    }

//    public List<UsersRoles> getAll(Long id){
//        return usersRolesService.getAll(id);
//    }

}
