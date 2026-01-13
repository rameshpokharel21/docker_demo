package com.ramesh.docker_demo.service;

import com.ramesh.docker_demo.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
}
