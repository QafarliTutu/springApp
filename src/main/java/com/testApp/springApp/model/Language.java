package com.testApp.springApp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Language {

    @Id
    @Column(name = "language_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String code;
    private byte isVisible;

    @OneToMany(mappedBy = "language")
    private Set<EducationTranslations> eTranslations;


}
