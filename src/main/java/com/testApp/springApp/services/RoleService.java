package com.testApp.springApp.services;

import com.testApp.springApp.dto.RoleDto;
import com.testApp.springApp.exceptions.NotFoundException;
import com.testApp.springApp.exceptions.RoleAlreadyExistEx;
import com.testApp.springApp.exceptions.RoleNoteFoundEx;
import com.testApp.springApp.model.Role;
import com.testApp.springApp.repository.RoleRepo;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    private final RoleRepo roleRepo;

    public RoleService(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public RoleDto createRole(RoleDto roleDto) {
        boolean existByName = roleRepo.existByName(roleDto.getName());
        if (!existByName) {
            Role role = new Role();
            BeanUtils.copyProperties(roleDto, role);
            roleRepo.save(role);
            BeanUtils.copyProperties(role, roleDto);
            return roleDto;
        } else throw new RoleAlreadyExistEx();

    }

    public RoleDto findById(Long id) {
        Optional<Role> byId = roleRepo.findById(id);
        if (byId.isPresent()) {
            RoleDto roleDto = new RoleDto();
            BeanUtils.copyProperties(byId, roleDto);
            return roleDto;
        } else throw new RoleNoteFoundEx();

    }

    public RoleDto updateRole(Long id, RoleDto roleDto) {
        Optional<Role> byId = roleRepo.findById(id);
        if (byId.isPresent()) {
            Role role = byId.get();
            BeanUtils.copyProperties(roleDto, role);
            role.setId(id);
            roleRepo.save(role);
            BeanUtils.copyProperties(role, roleDto);
            return roleDto;
        }
        throw new RoleNoteFoundEx();
    }

}
