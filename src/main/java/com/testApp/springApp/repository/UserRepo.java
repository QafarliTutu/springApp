package com.testApp.springApp.repository;

import com.testApp.springApp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<Users,Long>{

}
