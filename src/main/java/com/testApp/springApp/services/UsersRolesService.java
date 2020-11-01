package com.testApp.springApp.services;

import com.testApp.springApp.dto.RoleDto;
import com.testApp.springApp.dto.UserDto;
import com.testApp.springApp.dto.UsersRolesDto;
import com.testApp.springApp.exceptions.RoleAlreadyExistEx;
import com.testApp.springApp.model.Role;
import com.testApp.springApp.model.Users;
import com.testApp.springApp.model.UsersRoles;
import com.testApp.springApp.repository.UserRoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersRolesService {

    private final UserRoleRepo userRoleRepo;

    private final RoleService roleService;

    private final UserService userService;


    public UsersRolesDto createUserRole(UsersRolesDto usersRolesDto) {
        List<Long> roles = userRoleRepo.findAllByUsersId(usersRolesDto.getUsersId())
                    .stream()
                    .map(usersRoles -> usersRoles.getRole().getId())
                    .collect(Collectors.toList());
        if(!roles.contains(usersRolesDto.getRolesId()) ){
            Role role = new Role();
            RoleDto roleDto = roleService.findById(usersRolesDto.getRolesId());
            BeanUtils.copyProperties(roleDto,role);

            Users user = new Users();
            UserDto userDto = userService.findById(usersRolesDto.getUsersId());
            BeanUtils.copyProperties(userDto,user);

            UsersRoles usersRoles = new UsersRoles();
            BeanUtils.copyProperties(usersRolesDto,usersRoles);
            if(usersRolesDto.getPermissions()==null){
                usersRoles.setPermissions(role.getDefaultPermissions());
            }
            usersRoles.setRole(role);
            usersRoles.setUsers(user);
            userRoleRepo.save(usersRoles);
            BeanUtils.copyProperties(usersRoles,usersRolesDto);
        }return usersRolesDto;

    }


    public UsersRolesDto findById(Long id) {
        return null;
    }

    public List<UsersRoles> getAll(Long id) {
        return null;
    }
}
