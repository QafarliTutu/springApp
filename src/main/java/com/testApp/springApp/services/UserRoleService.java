package com.testApp.springApp.services;

import com.testApp.springApp.dto.RoleDto;
import com.testApp.springApp.dto.UserDto;
import com.testApp.springApp.dto.UserRoleDto;
import com.testApp.springApp.exceptions.UserAlreadyHasRoleEx;
import com.testApp.springApp.exceptions.UserRoleNotFoundEx;
import com.testApp.springApp.model.Role;
import com.testApp.springApp.model.User;
import com.testApp.springApp.model.UserRole;
import com.testApp.springApp.repository.UserRoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRoleService {

    private final UserRoleRepo userRoleRepo;

    private final RoleService roleService;

    private final UserService userService;


    public UserRoleDto createUserRole(UserRoleDto userRoleDto) {
        boolean existsByUserId = userRoleRepo.existsByUserId(userRoleDto.getUserId());
        if(!existsByUserId){
            Role role = new Role();
            RoleDto roleDto = roleService.findById(userRoleDto.getRoleId());
            BeanUtils.copyProperties(roleDto, role);

            User user = new User();
            UserDto userDto = userService.findById(userRoleDto.getUserId());
            BeanUtils.copyProperties(userDto, user);

            UserRole userRole = new UserRole();
            BeanUtils.copyProperties(userRoleDto, userRole);

            userRole.setRole(role);
            userRole.setUser(user);
            userRoleRepo.save(userRole);
            BeanUtils.copyProperties(userRole, userRoleDto);
            return userRoleDto;
        }else throw new UserAlreadyHasRoleEx();

    }

    public UserRoleDto findById(Long id) {
        return null;
    }

    public List<UserRole> getAll(Long id) {
        return null;
    }

    public UserRoleDto updateUserRole(Long id, UserRoleDto userRoleDto) {
        boolean existsByUserId = userRoleRepo.existsByUserId(userRoleDto.getUserId());
        if(existsByUserId){
            UserRole userRole = userRoleRepo.findByUserId(userRoleDto.getUserId());

            Role role = new Role();
            RoleDto roleDto = roleService.findById(userRoleDto.getRoleId());
            BeanUtils.copyProperties(roleDto, role);

            User user = new User();
            UserDto userDto = userService.findById(userRoleDto.getUserId());
            BeanUtils.copyProperties(userDto, user);

            BeanUtils.copyProperties(userRoleDto, userRole);

            userRole.setRole(role);
            userRole.setUser(user);
            userRole.setId(id);
            userRoleRepo.save(userRole);
            BeanUtils.copyProperties(userRole, userRoleDto);
            return userRoleDto;
        }else throw new UserRoleNotFoundEx();
    }
}
