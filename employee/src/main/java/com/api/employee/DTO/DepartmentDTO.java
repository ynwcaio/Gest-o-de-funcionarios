package com.api.employee.DTO;

import com.api.employee.database.Department;

import java.util.UUID;

public class DepartmentDTO {

    private UUID id;
    private String departmentName;

    public DepartmentDTO(Department department) {
        this.id = department.getId();
        this.departmentName = department.getDepartmentName();
    }

    public UUID getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
