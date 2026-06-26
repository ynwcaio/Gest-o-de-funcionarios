package com.api.employee.service;


import com.api.employee.DTO.DepartmentDTO;
import com.api.employee.database.Department;
import com.api.employee.database.DepartmentRepository;
import com.api.employee.exceptions.DepartmentNotFound;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Transactional(readOnly = true)
    public List<DepartmentDTO> findAllDepartments(){
        List<Department> department = departmentRepository.findAll();
        return department.
                stream()
                .map(DepartmentDTO :: new)
                .toList();
    }

    @Transactional(readOnly = true)
    public DepartmentDTO findAllDepartmentsById(UUID id){
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFound("Department not found"));

        return new DepartmentDTO(department);
    }

    @Transactional
    public DepartmentDTO saveDepartment(DepartmentDTO dto){

        Department department = new Department();
        department.setDepartmentName(dto.getDepartmentName());

        department = departmentRepository.save(department);

        dto = new DepartmentDTO(department);

        return dto;

    }
}
