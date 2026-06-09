package com.module3.cms.entity;

import jakarta.persistence.Entity;

@Entity
public class Students {

    private Long id;
    private String name;
    private Professor professor;
    private Subjects subjects;
}
