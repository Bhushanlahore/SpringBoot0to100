package com.module3.cms.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class AdmissionRequestDTO {

    private String addmissionNo;
    private Integer fees;
    private LocalDateTime addmissionDate;
    private Long studentId;
}
