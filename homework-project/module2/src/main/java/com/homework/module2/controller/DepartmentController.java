package com.homework.module2.controller;

import com.homework.module2.dto.DepartmentDTO;
import com.homework.module2.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/departments")
public class DepartmentController{

    private final DepartmentService departmentService;


    @GetMapping(path = "/{deptId}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable(name = "deptId") Long id) {
        DepartmentDTO departmentById = departmentService.getDepartmentById(id);
        return new ResponseEntity<>(departmentById, HttpStatus.OK);
    }

    @GetMapping(path= "/getAll")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartment(){
        List<DepartmentDTO> departmentDTOList = departmentService.getDepartments();
        return  new ResponseEntity<>(departmentDTOList, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public  ResponseEntity<DepartmentDTO> AddDepartment(@RequestBody @Valid DepartmentDTO dto){
        DepartmentDTO departmentDTO = departmentService.addDepartment(dto);
        return new ResponseEntity<>(departmentDTO, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{deptId}")
    public ResponseEntity<DepartmentDTO> updateDepartmentById(@PathVariable Long deptId, @RequestBody @Valid DepartmentDTO dto){
        DepartmentDTO departmentDTO = departmentService.updateDepartmentById(deptId, dto);
        return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{deptId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long deptId) {
        boolean gotDeleted = departmentService.deleteDepartment(deptId);
        if (gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping(path = "/{deptId}")
    public ResponseEntity<DepartmentDTO> updatePartialEmployeeById(@RequestBody Map<String, Object> updates,
                                                                 @PathVariable Long deptId) {
        DepartmentDTO departmentDTO = departmentService.updatePartialDepartmentById(deptId, updates);
        if (departmentDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(departmentDTO);
    }
}
