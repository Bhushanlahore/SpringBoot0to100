package com.module3.cms.controller;

import com.module3.cms.dto.StudentRequestDTO;
import com.module3.cms.dto.StudentsResponseDTO;
import com.module3.cms.service.StudentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentsController {

    private final StudentsService studentsService;

    @PostMapping("/create")
    public ResponseEntity<StudentsResponseDTO> createStudent(@RequestBody StudentRequestDTO dto){
        StudentsResponseDTO student = studentsService.createStudent(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentsResponseDTO> updateStudent(@PathVariable Long id, @RequestBody StudentRequestDTO dto){
        StudentsResponseDTO student = studentsService.updateStudentDetails(id,dto);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }
}
