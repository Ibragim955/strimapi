package com.example.streamapi.controllers;

import com.example.streamapi.Employee;
import com.example.streamapi.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")

public class DepartmentController {
    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("max-salary")
    public Optional<Employee> maxSalary(@RequestParam ("departmentId") int departmentId) {
        return departmentService.findMaxSalary(departmentId);
    }
    @GetMapping("min-salary")
    public Optional<Employee> minSalary(@RequestParam ("departmentId") int departmentId) {
        return departmentService.findMinSalary(departmentId);
    }
    @GetMapping("all")
    public List<Employee> findAll(@RequestParam ("departmentId") int departmentId) {
        return departmentService.findAll(departmentId);
    }

}
