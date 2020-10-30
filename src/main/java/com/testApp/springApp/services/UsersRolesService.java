package com.testApp.springApp.services;

import com.testApp.springApp.dto.UsersRolesDto;
import com.testApp.springApp.model.UsersRoles;
import com.testApp.springApp.repository.UserRoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersRolesService {

    private final UserRoleRepo userRoleRepo;


    public UsersRolesDto createUserRole(UsersRolesDto usersRolesDto) {
        userRoleRepo.findAllByUsersId(usersRolesDto.getUsersId())
                .stream();
        return null;
    }


    public UsersRolesDto findById(Long id) {
        return null;
    }

    public List<UsersRoles> getAll(Long id) {
        return null;
    }
}
