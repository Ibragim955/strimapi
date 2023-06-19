package com.example.streamapi;

import java.util.Objects;

public class Employee {
private String fullname;
private String lastname;
private int salary;
private int departmentId;

    public Employee(String fullname, String lastname) {
        this.fullname = fullname;
        this.lastname = lastname;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public String getFullname() {
        return fullname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && departmentId == employee.departmentId && Objects.equals(fullname, employee.fullname) && Objects.equals(lastname, employee.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullname, lastname, salary, departmentId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullname='" + fullname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", salary=" + salary +
                ", departmentId=" + departmentId +
                '}';
    }
}
