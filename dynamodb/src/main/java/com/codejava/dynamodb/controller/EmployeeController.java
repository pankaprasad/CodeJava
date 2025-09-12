package com.codejava.dynamodb.controller;


import com.codejava.dynamodb.entity.Department;
import com.codejava.dynamodb.entity.Employee;
import com.codejava.dynamodb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/saveEmployee")
    public Employee getEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("First Name");
        employee.setLastName("Last Name");
        employee.setEmail("Email");
        Department department = new Department();
        department.setDepartmentName("Department");
        department.setDepartmentCode("DepartmentCode");
        employee.setDepartment(department);
        employeeRepository.save(employee);
        return ResponseEntity.ok().body(employee).getBody();

    }
}
