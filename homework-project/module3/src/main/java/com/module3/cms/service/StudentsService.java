package com.module3.cms.service;

import com.module3.cms.dto.StudentRequestDTO;
import com.module3.cms.dto.StudentsResponseDTO;

public interface StudentsService {

    StudentsResponseDTO createStudent(StudentRequestDTO dto);

    StudentsResponseDTO updateStudentDetails(Long id, StudentRequestDTO dto);

    StudentsResponseDTO assignProfeeser(Long studentId, Long ProfessorId);

    StudentsResponseDTO assignSubjects(Long studentId, Long courseId);
}
