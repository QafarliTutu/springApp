package com.testApp.springApp.model;


import com.testApp.springApp.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Roles {


    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String defaultPermissions;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "roles")
    private List<UsersRoles> users_roles;

    @Override
    public String toString() {
        return "Roles{" +
                "name=" + name +
                "deleted_at="+ deletedAt;

    }
}
