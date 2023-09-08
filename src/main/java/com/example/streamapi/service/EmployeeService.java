package com.example.streamapi.service;

import com.example.streamapi.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service

public interface EmployeeService {

    Employee add(Employee employee);


    Collection<Employee> getEmployees();

    Employee add(String fullname, String lastname);

    //
    //
    //
    
}
