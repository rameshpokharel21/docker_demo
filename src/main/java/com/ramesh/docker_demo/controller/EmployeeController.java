package com.ramesh.docker_demo.controller;

import com.ramesh.docker_demo.dto.EmployeeDto;
import com.ramesh.docker_demo.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody @Valid EmployeeDto employeeDto){
        EmployeeDto dto = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto dto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employeeDtos = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeDtos);
    }

    //build Update Employee REST API
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody @Valid EmployeeDto newEmployee){
        EmployeeDto updatedEmployeeDto = employeeService.updateEmployee(employeeId, newEmployee);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedEmployeeDto);
    }

    //build Delete Employee REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity
                .noContent().build();
    }
}
