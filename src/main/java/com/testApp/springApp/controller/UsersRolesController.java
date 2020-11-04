package com.testApp.springApp.controller;

import com.testApp.springApp.dto.UserRoleDto;
import com.testApp.springApp.services.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/usersRoles")
@RequiredArgsConstructor
public class UsersRolesController {

    private final UserRoleService userRoleService;

    @PostMapping("create")
    public UserRoleDto createUserRole(@RequestBody UserRoleDto userRoleDto) {
        return userRoleService.createUserRole(userRoleDto);
    }

    @GetMapping("find/{id}")
    public UserRoleDto findById(@PathVariable("id") Long id) {
        return userRoleService.findById(id);
    }

    @PutMapping("update/{id}")
    public UserRoleDto updateUserRole(@PathVariable("id") Long id, @RequestBody UserRoleDto userRoleDto) {
        return userRoleService.updateUserRole(id, userRoleDto);
    }


//    public List<UsersRoles> getAll(Long id){
//        return usersRolesService.getAll(id);
//    }

}
