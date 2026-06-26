package com.api.employee.Controller;


import com.api.employee.DTO.EmployeeDTO;
import com.api.employee.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAll(){
        return ResponseEntity
                .ok(employeeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable UUID id){
        return ResponseEntity
                .ok(employeeService.findById(id));
    }


    @PostMapping
    public ResponseEntity<EmployeeDTO> create(@RequestBody EmployeeDTO dto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(employeeService.insert(dto));
    }

    @PutMapping
    public ResponseEntity<EmployeeDTO> update(@PathVariable UUID id, @RequestBody EmployeeDTO dto){
        return ResponseEntity
                .ok(employeeService.update(id, dto));
    }


    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable UUID id) {
        employeeService.delete(id);
    }


}
