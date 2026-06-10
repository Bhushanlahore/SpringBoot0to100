package com.module3.cms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdmissionDTO {

    private Integer fees;
    private LocalDateTime admissionDate;
    private Long studentId;
}
