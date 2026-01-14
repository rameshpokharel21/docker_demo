package com.ramesh.docker_demo.service;

import com.ramesh.docker_demo.dto.EmployeeDto;
import com.ramesh.docker_demo.entity.Employee;
import com.ramesh.docker_demo.exception.EmailAlreadyExistsException;
import com.ramesh.docker_demo.exception.ResourceNotFoundException;
import com.ramesh.docker_demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Optional<Employee> optionalEmployee = employeeRepository.findByEmail(employeeDto.getEmail());
        if(optionalEmployee.isPresent()){
            throw new EmailAlreadyExistsException("Email already exists.");
        }

        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAllEmployees(){
        return employeeRepository.findAll()
                .stream()
                .map(e -> modelMapper.map(e, EmployeeDto.class))
                .toList();
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto newEmployeeDto) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));
        employee.setFirstName(newEmployeeDto.getFirstName());
        employee.setLastName(newEmployeeDto.getLastName());
        employee.setEmail(newEmployeeDto.getEmail());
        Employee savedUpdatedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedUpdatedEmployee, EmployeeDto.class);
    }
}
