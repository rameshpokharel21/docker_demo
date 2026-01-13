package com.ramesh.docker_demo.repository;

import com.ramesh.docker_demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
