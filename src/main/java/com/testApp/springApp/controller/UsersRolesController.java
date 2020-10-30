package com.testApp.springApp.controller;

import com.testApp.springApp.dto.LanguageDto;
import com.testApp.springApp.dto.UsersRolesDto;
import com.testApp.springApp.model.UsersRoles;
import com.testApp.springApp.services.UsersRolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/usersRoles")
@RequiredArgsConstructor
public class UsersRolesController {

    private final UsersRolesService usersRolesService;

//    @PostMapping("create")
//    public UsersRolesDto createUserRole(@RequestBody UsersRolesDto usersRolesDto){
//        return usersRolesService.createUserRole(usersRolesDto);
//    }
//
//    @GetMapping("find/{id}")
//    public UsersRolesDto findById(@PathVariable("id") Long id){
//        return usersRolesService.findById(id);
//    }

    public List<UsersRoles> getAll(Long id){
        return usersRolesService.getAll(id);
    }
}
