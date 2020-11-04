package com.testApp.springApp.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "usersRoles")
public class UserRole {

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
    private User user;

    @CreationTimestamp
    @Column(name = "createdAt",updatable = false,nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    @Column(name = "deletedAt")
    private LocalDateTime deletedAt;

    @Column(name = "status",columnDefinition = "boolean default true")
    private Boolean status;

}
