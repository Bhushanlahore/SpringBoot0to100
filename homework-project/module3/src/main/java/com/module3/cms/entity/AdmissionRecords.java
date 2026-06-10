package com.module3.cms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;

@Entity
@Table(name = "admission_records")
@Getter
@Setter
@ToString
public class AdmissionRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String addmissionNo;
    private Integer fees;
    private LocalDateTime addmissionDate;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Students students;  //owning side
}
