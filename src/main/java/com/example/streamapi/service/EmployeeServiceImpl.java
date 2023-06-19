package com.example.streamapi.service;

import com.example.streamapi.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class EmployeeServiceImpl implements EmployeeService{
//
//    List<Employee>  = new ArrayList<> (List.of(
//            new Employee("alex Volkanovckiy", "lastName", 23000, 1),
//            new Employee("asddfss Volkanovckiy", "lastName", 23000, 1),
//            new Employee("fsdfd Volkanovckiy", "lastName", 23000, 1),
//            new Employee("sdfjr Volkanovckiy", "lastName", 23000, 1),
//            new Employee("fwihfw Volkanovckiy", "lastName", 23000, 1)
//    ));
    Map<String, Employee> lists = new HashMap<>(Map.of());

    @Override
    public Employee add(Employee employee) {
        lists.put(employee.getFullname() + employee.getLastname(), employee);
        return employee;
    }

    @Override
    public Collection<Employee> getEmployees() {
        return null;
    }

    @Override
    public Employee add(String fullname, String lastname) {
        return null;
    }


}

