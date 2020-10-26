package com.testApp.springApp.dto;

import com.testApp.springApp.model.Employee;
import com.testApp.springApp.model.UsersRoles;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Validated
public class UserDto {

    private Long id;

    @NotBlank
    private Long employeeId;

    @NotBlank
    private String name;

    private String password;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    private List<UsersRoles> users_roles;



}
