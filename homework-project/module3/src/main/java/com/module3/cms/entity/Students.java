package com.module3.cms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(name = "student_professor",
                joinColumns =  @JoinColumn(name = "student_id"),
                inverseJoinColumns = @JoinColumn(name = "professor_id"))  //owning side
    private List<Professor> professors = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "student_subjects",
                joinColumns = @JoinColumn(name = "student_id"),   //owning side
                inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subjects> subjects = new ArrayList<>();


    @OneToOne(mappedBy = "students")
    private AdmissionRecords admissionRecords;  //inverse side

}
