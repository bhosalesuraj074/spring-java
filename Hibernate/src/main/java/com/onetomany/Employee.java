package com.onetomany;

public class Employee {
    private long id;
    private String empName;
    private Department department;

    public Employee(long id, String empName, Department department) {
        this.id = id;
        this.empName = empName;
        this.department = department;
    }

    public Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
