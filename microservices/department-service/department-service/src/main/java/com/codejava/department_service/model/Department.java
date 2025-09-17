package com.codejava.department_service.model;

public class Department {

    public String   name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long deptId;
    //Employee employee;

    public Department(String name, Long deptId) {
        this.name = name;
        this.deptId = deptId;
      //  this.employee = employee;
    }
}
