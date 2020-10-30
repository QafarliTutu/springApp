package com.testApp.springApp.controller;

import com.testApp.springApp.dto.RoleDto;
import com.testApp.springApp.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("create")
    public RoleDto createRole(@RequestBody RoleDto roleDto) {
        return roleService.createRole(roleDto);
    }

    @GetMapping("find/{id}")
    public RoleDto findById(@PathVariable("id") Long id) {
        return roleService.findById(id);
    }

    @PutMapping("update/{id}")
    public RoleDto updateRole(@PathVariable("id") Long id, @RequestBody RoleDto roleDto) {
        return roleService.updateRole(id, roleDto);
    }

    @DeleteMapping("delete/{id}")
    public void deleteRole(@PathVariable("id") Long id) {
        roleService.deleteById(id);
    }
}
