package com.homework.module2.service;

import com.homework.module2.dto.DepartmentDTO;
import com.homework.module2.entity.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    List<DepartmentDTO> getDepartments();

    DepartmentDTO addDepartment(DepartmentDTO departmentDTO);

    DepartmentDTO updateDepartmentById(Long id, DepartmentDTO departmentDTO);

    DepartmentDTO getDepartmentById(Long id);

    boolean deleteDepartment(Long id);

    public DepartmentDTO updatePartialDepartmentById(Long deptId, Map<String, Object> updates);

}
