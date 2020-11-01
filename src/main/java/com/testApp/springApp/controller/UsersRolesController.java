package com.testApp.springApp.controller;

import com.testApp.springApp.dto.UsersRolesDto;
import com.testApp.springApp.services.UsersRolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/usersRoles")
@RequiredArgsConstructor
public class UsersRolesController {

    private final UsersRolesService usersRolesService;

    @PostMapping("create")
    public UsersRolesDto createOrUpdateUserRole(@RequestBody UsersRolesDto usersRolesDto){
        return usersRolesService.createUserRole(usersRolesDto);
    }

    @GetMapping("find/{id}")
    public UsersRolesDto findById(@PathVariable("id") Long id){
        return usersRolesService.findById(id);
    }

//    public List<UsersRoles> getAll(Long id){
//        return usersRolesService.getAll(id);
//    }

}
