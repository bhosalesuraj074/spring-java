package com.onetomany;

import java.util.Set;

public class Department {
    private int id;
    private String departmentName;
    private Set<Employee> employees;

    public Department() {
    }

    public Department(int id, String departmentName, Set<Employee> employees) {
        this.id = id;
        this.departmentName = departmentName;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
