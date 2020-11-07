package com.testApp.springApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "educationTr")
public class EducationTr {

    @Id
    @Column(name = "educationTrId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;//orta,fhdj

    @CreationTimestamp
    @Column(name = "createdAt",updatable = false,nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    @Column(name = "deletedAt")
    private LocalDateTime deletedAt;

    @ManyToOne
    @JoinColumn(name = "languageId")
    private Language language;


    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "educationId")
    private Education education;

    @Column(name = "status")
    private Boolean status;
}
