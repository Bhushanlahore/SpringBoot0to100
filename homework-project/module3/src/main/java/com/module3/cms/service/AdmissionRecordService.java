package com.module3.cms.service;

import com.module3.cms.dto.AdmissionRequestDTO;
import com.module3.cms.dto.AdmissionResponseDTO;

public interface AdmissionRecordService {

    public AdmissionResponseDTO createAdmission(AdmissionRequestDTO dto);

    public boolean deleteAddmission(Long id);
}
