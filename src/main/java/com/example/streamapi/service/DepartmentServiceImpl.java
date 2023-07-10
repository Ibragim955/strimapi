package com.example.streamapi.service;

import com.example.streamapi.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service

public class DepartmentServiceImpl implements DepartmentService{
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }



    @Override
    public Optional<Employee> findMaxSalary(Integer departmentId) {

        return   employeeService.getEmployees().stream()
                .filter(e -> Objects.equals(e.getDepartmentId(), departmentId ))
                .max(Comparator.comparing(Employee::getSalary));
    }

    @Override
    public Map findAll(Integer departmentId) {
        return (Map) employeeService.getEmployees().stream()
                .filter(e -> Objects.equals(e.getDepartmentId(), departmentId ))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Employee> findMinSalary(Integer departmentId) {
        return   employeeService.getEmployees().stream()
                .filter(e -> Objects.equals(e.getDepartmentId(), departmentId ))
                .max(Comparator.comparing(Employee::getSalary));
    }
}
