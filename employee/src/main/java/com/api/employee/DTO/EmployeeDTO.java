package com.api.employee.DTO;

import com.api.employee.database.Department;
import com.api.employee.database.Employee;

import java.math.BigDecimal;
import java.util.UUID;

public class EmployeeDTO {
    private UUID id;
    private String name;
    private String email;
    private Integer age;
    private BigDecimal salary;
    private Department department;


    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.email = employee.getEmail();
        this.age = employee.getAge();
        this.salary = employee.getSalary();
        this.department = employee.getDepartment();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
