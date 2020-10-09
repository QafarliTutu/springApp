package com.testApp.springApp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EducationTranslations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "education_id")
    private Language language;


    @ManyToOne
    @JoinColumn(name = "language_id")
    private Education education;

}
