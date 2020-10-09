package com.testApp.springApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersRoles {

    @Id
    @Column(name = "users_role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String permissions;


    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roles;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;


}
