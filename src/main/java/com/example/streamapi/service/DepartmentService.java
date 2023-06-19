package com.example.streamapi.service;

import com.example.streamapi.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public interface DepartmentService {
    Optional<Employee> findMaxSalary(Integer departmentId);

    List<Employee> findAll(Integer departmentId);

    Optional<Employee> findMinSalary(Integer departmentId);

}
