package com.testApp.springApp.repository;

import com.testApp.springApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

public interface JPA<T> extends JpaRepository<T, Long> {

    Optional<T> findById(Long id);

    Optional<T> findByName(String name);
    Optional<T> findByEmail(String name);

    boolean existsByEmail(String email);
    boolean existsByContact(String contact);
}
