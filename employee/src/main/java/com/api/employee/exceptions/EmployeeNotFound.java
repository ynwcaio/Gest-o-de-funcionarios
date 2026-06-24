package com.api.employee.exceptions;

public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound(String message) {
        super(message);
    }
}
