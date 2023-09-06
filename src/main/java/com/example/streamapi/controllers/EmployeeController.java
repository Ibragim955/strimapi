package com.example.streamapi.controllers;

import com.example.streamapi.Employee;
import com.example.streamapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService service;

    public EmployeeController(@Qualifier("employeeService") EmployeeService service) {
        this.service = service;
    }


    @GetMapping("/add")
    public Employee add(@RequestParam("name") String fullname, @RequestParam("lastName") String lastname) {
        return service.add(new Employee(fullname, lastname));
    }
@GetMapping("/find")
    public Employee find(@RequestParam String fullname, @RequestParam String lastname) {
        return service.add(fullname, lastname);
    }
@GetMapping("/remove")
    public Employee remove(@RequestParam String fullname, @RequestParam String lastname) {
        return service.add(fullname, lastname);
    }
@GetMapping("/all")
    public Collection<Employee> remove(){
        return service.getEmployees();
    }
}
//ew