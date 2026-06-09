package com.module3.cms.entity;

import jakarta.persistence.Entity;

@Entity
public class Professor {

    private Long id;
    private String name;
    private Subjects subjects;
    private Students students;
}
