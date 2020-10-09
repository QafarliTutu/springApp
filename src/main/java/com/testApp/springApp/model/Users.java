package com.testApp.springApp.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Users {


    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String password;
    private String permissions;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employees employees;

    @OneToMany(mappedBy = "users")
    private List<UsersRoles> users_roles;

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                "employee="+ employees;
    }
}
