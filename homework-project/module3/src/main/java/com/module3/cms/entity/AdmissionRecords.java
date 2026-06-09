package com.module3.cms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "admission_records")
@Getter
@Setter
public class AdmissionRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer fees;
    @CreationTimestamp
    private LocalDateTime createdAt;



    @OneToOne
    @JoinColumn(name = "student_id")
    private Students students;  //owning side
}
