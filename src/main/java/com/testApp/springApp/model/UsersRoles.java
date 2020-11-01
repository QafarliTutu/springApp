package com.testApp.springApp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "usersRoles")
public class UsersRoles {

    @Id
    @Column(name = "userRoleId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "permissions")
    private String permissions;

    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId")
    private Role role;

    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private Users users;


}
