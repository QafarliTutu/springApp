package com.testApp.springApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "language")
public class Language {

    @Id
    @Column(name = "languageId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "isVisible")
    private Boolean isVisible;

    @OneToMany(mappedBy = "language", cascade = CascadeType.REMOVE)
    private Set<EducationTr> educationTr;


}
