package com.codejava.department_service.client;


import com.codejava.department_service.model.Employee;
import com.codejava.department_service.service.WebClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface EmployeeClient {

    @GetExchange("/getEmployee")
    public ResponseEntity<Employee> getEmployee();
}