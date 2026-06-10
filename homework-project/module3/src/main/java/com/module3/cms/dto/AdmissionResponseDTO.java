package com.module3.cms.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class AdmissionResponseDTO {

    private String addmissionNo;
    private Integer fees;
    private LocalDateTime addmissionDate;
    private Long StudentId;
}
