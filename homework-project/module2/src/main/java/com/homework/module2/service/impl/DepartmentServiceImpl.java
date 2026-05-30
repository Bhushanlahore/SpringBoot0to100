package com.homework.module2.service.impl;

import com.homework.module2.dto.DepartmentDTO;
import com.homework.module2.entity.Department;
import com.homework.module2.exceptions.DepartmentNotFoundException;
import com.homework.module2.repository.DepartmentRepository;
import com.homework.module2.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<DepartmentDTO> getDepartments() {
        List<Department> departments = repository.findAll();
       return departments.stream()
                .map(dept -> mapper.map(dept, DepartmentDTO.class))
               .collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO getDepartmentById(Long id) {
          return  repository.findById(id)
                  .map(dept -> mapper.map(dept, DepartmentDTO.class))
                    .orElseThrow(() -> new DepartmentNotFoundException(" Department not found with Id: "+id));
    }

    @Override
    public DepartmentDTO addDepartment(DepartmentDTO departmentDTO) {
        Department departmentEntity = mapper.map(departmentDTO, Department.class);
        Department saveEntity = repository.save(departmentEntity);
        return mapper.map(saveEntity, DepartmentDTO.class);
    }

    @Override
    public DepartmentDTO updateDepartmentById(Long id, DepartmentDTO departmentDTO) {
        isExistsByEmployeeId(id);
        Department deptEntity = mapper.map(departmentDTO, Department.class);
        deptEntity.setDeptId(id);
        Department saveEntity = repository.save(deptEntity);
        return  mapper.map(saveEntity, DepartmentDTO.class);
    }

    @Override
    public boolean deleteDepartment(Long id) {
        isExistsByEmployeeId(id);
        repository.deleteById(id);
        return true;
    }

    @Override
    public DepartmentDTO updatePartialDepartmentById(Long deptId, Map<String, Object> updates) {
        isExistsByEmployeeId(deptId);
        Department department = repository.findById(deptId).get();

        updates.forEach((field, value)->{
            Field fieldToBeUpdated = ReflectionUtils.getRequiredField(Department.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, department, value);
        });
        return mapper.map(repository.save(department), DepartmentDTO.class);

    }

    private void isExistsByEmployeeId(Long id) {
        boolean exists = repository.existsById(id);
        if(!exists) throw new DepartmentNotFoundException("Department not found with id: "+id);
    }
}
