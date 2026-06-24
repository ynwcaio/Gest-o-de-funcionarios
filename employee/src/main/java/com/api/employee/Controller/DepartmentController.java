package com.api.employee.Controller;


import com.api.employee.DTO.DepartmentDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/api/department")
public class DepartmentController {

    @GetMapping
    public List<DepartmentDTO>
}
