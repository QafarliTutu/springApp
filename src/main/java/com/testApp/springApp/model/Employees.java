package com.testApp.springApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class Employees {

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

//    @Column(name = "password")
//    private String password;

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
    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    @Column(name = "deletedAt")
    private LocalDateTime deletedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "educationId")
    private Education educationId;

    @OneToMany(mappedBy = "employees")// cascade
    private Set<Users> users;

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
