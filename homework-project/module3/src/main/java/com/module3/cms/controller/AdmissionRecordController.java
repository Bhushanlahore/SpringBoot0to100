package com.module3.cms.controller;

import com.module3.cms.dto.AdmissionRequestDTO;
import com.module3.cms.dto.AdmissionResponseDTO;
import com.module3.cms.service.AdmissionRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admisson")
@RequiredArgsConstructor
public class AdmissionRecordController {

    private final AdmissionRecordService admissionService;

    @PostMapping("/create")
    public ResponseEntity<AdmissionResponseDTO> createAdmisson(@RequestBody AdmissionRequestDTO dto){
        AdmissionResponseDTO admission = admissionService.createAdmission(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(admission);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> createAdmisson(@PathVariable Long id){
        boolean result = admissionService.deleteAddmission(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
