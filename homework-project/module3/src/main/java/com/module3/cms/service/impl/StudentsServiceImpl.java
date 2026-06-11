package com.module3.cms.service.impl;

import com.module3.cms.dto.StudentRequestDTO;
import com.module3.cms.dto.StudentsResponseDTO;
import com.module3.cms.entity.Students;
import com.module3.cms.exception.RecordNotFoundException;
import com.module3.cms.exception.StudentNotFoundException;
import com.module3.cms.repository.StudentsRepository;
import com.module3.cms.service.StudentsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentsServiceImpl implements StudentsService {

    private final StudentsRepository studentsRepository;
    private final ModelMapper mapper;


    @Override
    public StudentsResponseDTO createStudent(StudentRequestDTO dto) {
      Students newStudent = studentsRepository.save(mapper.map(dto, Students.class));
        return mapper.map(newStudent, StudentsResponseDTO.class);

    }

    @Override
    public StudentsResponseDTO updateStudentDetails(Long id, StudentRequestDTO dto) {
       Students students = studentsRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Studnet not found with id: "+id));

      // students = studentsRepository.save(mapper.map(dto, Students.class));
        students = mapper.map(dto, Students.class);
        students.setId(id);
        studentsRepository.save(students);
        return mapper.map(students, StudentsResponseDTO.class);

    }

    @Override
    public StudentsResponseDTO assignProfeeser(Long studnetId, Long ProfessorId) {
        return null;
    }

    @Override
    public StudentsResponseDTO assignSubjects(Long studentId, Long courseId) {
        return null;
    }

    @Override
    public boolean deleteStudent(Long id) {

        Students students = studentsRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Resource not found"));
        studentsRepository.delete(students);
        return true;

    }
}
