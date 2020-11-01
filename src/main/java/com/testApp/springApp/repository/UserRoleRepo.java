package com.testApp.springApp.repository;

import com.testApp.springApp.model.Role;
import com.testApp.springApp.model.UsersRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRoleRepo extends JpaRepository<UsersRoles,List<Long>> {

    List<UsersRoles> findAllByUsersId(Long id);
    List<UsersRoles>  findAllRoleIdByUsersId(Long id);
    boolean existsByUsersId(Long id);
}
