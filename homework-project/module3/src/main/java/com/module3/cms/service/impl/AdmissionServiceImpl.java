package com.module3.cms.service.impl;

import com.module3.cms.dto.AdmissionRequestDTO;
import com.module3.cms.dto.AdmissionResponseDTO;
import com.module3.cms.entity.AdmissionRecords;
import com.module3.cms.entity.Students;
import com.module3.cms.exception.RecordNotFoundException;
import com.module3.cms.exception.StudentNotFoundException;
import com.module3.cms.repository.AdmissionRecordsRepository;
import com.module3.cms.repository.StudentsRepository;
import com.module3.cms.service.AdmissionRecordService;
import com.module3.cms.service.StudentsService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdmissionServiceImpl implements AdmissionRecordService {

    private final AdmissionRecordsRepository admissioRepository;
    private final StudentsRepository studentsRepository;
    private final ModelMapper mapper;


    @Override
    @Transactional
    public AdmissionResponseDTO createAdmission(AdmissionRequestDTO dto) {

       Students students = studentsRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: "+dto.getStudentId()));

       AdmissionRecords records = new AdmissionRecords();
       records.setFees(dto.getFees());
       records.setAddmissionDate(dto.getAddmissionDate());
       records.setAddmissionNo(dto.getAddmissionNo());
       records.setStudents(students);

       AdmissionRecords save = admissioRepository.save(records);

       AdmissionResponseDTO newAdmissionResponseDTO = mapper.map(save, AdmissionResponseDTO.class);
       newAdmissionResponseDTO.setStudentId(students.getId());
        System.out.println("newAdmissionResponseDTO "+ newAdmissionResponseDTO);
       return newAdmissionResponseDTO;
    }


    @Override
    @Transactional
    public boolean deleteAddmission(Long id) {
           AdmissionRecords records = admissioRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("Record not found with Id "+id));

        System.out.println("Step 2");

        admissioRepository.delete(records);

        System.out.println("Step 3");

        admissioRepository.flush();

        System.out.println("Step 4");


        System.out.println(
                "Exists After Delete = "
                        + admissioRepository.existsById(id));
           return true;
    }
}
