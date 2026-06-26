package com.api.employee.service;


import com.api.employee.DTO.EmployeeDTO;
import com.api.employee.database.Department;
import com.api.employee.database.DepartmentRepository;
import com.api.employee.database.Employee;
import com.api.employee.database.EmployeeRepository;
import com.api.employee.exceptions.DepartmentNotFound;
import com.api.employee.exceptions.EmployeeNotFound;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository,DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional(readOnly = true)
    public List<EmployeeDTO> findAll(){
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(EmployeeDTO :: new)
                .toList();
    }

    @Transactional(readOnly = true)
    public EmployeeDTO findById(UUID id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFound("Employee not found with id: " + id));

        return new  EmployeeDTO(employee);
    }

    @Transactional
    public EmployeeDTO insert(EmployeeDTO dto){

        Employee employee = new Employee();

        Department department = departmentRepository.findById(dto.getDepartment().getId())
                .orElseThrow(() -> new DepartmentNotFound("Department not found with ID: " + dto.getDepartment().getId()));

        employee.setName(dto.getName());

        employee.setEmail(dto.getEmail());

        employee.setAge(dto.getAge());

        employee.setSalary(dto.getSalary());

        employee.setDepartment(department);

        employeeRepository.save(employee);

        return new EmployeeDTO(employee);
    }


    @Transactional
    public EmployeeDTO update(UUID id, EmployeeDTO dto){

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFound("Employee not found with ID: " + id));

        Department department = departmentRepository.findById(dto.getDepartment().getId())
                .orElseThrow(() -> new DepartmentNotFound("Department not found with ID: " + dto.getDepartment().getId()));

        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setAge(dto.getAge());
        employee.setSalary(dto.getSalary());
        employee.setDepartment(department);

        employeeRepository.save(employee);

        return new EmployeeDTO(employee);

    }


    @Transactional
    public void delete(UUID id){
        employeeRepository.deleteById(id);
    }
}
