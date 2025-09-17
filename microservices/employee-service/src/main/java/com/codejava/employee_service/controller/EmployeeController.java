package com.codejava.employee_service.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private record Employee(Integer id, String name, double price) {}

    @GetMapping("/getEmployee")
    public ResponseEntity<Employee> getEmployee() {
        Employee employee = new Employee(1, "John Smith", 50000);
        return ResponseEntity.ok(employee);
    }


}
