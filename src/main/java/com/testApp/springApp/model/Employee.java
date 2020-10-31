package com.testApp.springApp.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "employeeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "image")
    private String image;

    @Column(name = "address")
    private String address;

    @Column(name = "contact")
    private String contact;

    @Column(name = "birthdate")
    private String birthdate;

    @Column(name = "salary")
    private BigDecimal salary;

    private double DSMF;//TODO DEQIQLESDIR!

    @CreationTimestamp
    @Column(name = "createdAt",updatable = false,nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    @Column(name = "deletedAt")
    private LocalDateTime deletedAt;

    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "educationId")
    private Education education;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.REMOVE)
    private Set<Users> users;

}
