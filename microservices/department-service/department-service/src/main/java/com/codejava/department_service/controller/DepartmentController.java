package com.codejava.department_service.controller;


import com.codejava.department_service.client.EmployeeClient;
import com.codejava.department_service.model.Department;
import com.codejava.department_service.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    //@Autowired
    //EmployeeClient employeeClient;

    private final WebClient webClient;

    private Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @GetMapping(value = "/getDepartments")
    public ResponseEntity<Department> getDepartment() {
        logger.info("getDepartment is called");
        Department department = new Department("name", 1L);
        return ResponseEntity.ok().body(department);
    }

    @GetMapping("/getEmployee")
    public Mono<Employee> getEmployee() {
        try {
            logger.info("getEmployee is called from Department Controller");
            Mono<Employee> employeeMono = getEmployeeDetails();
            return employeeMono.flatMap(Mono::just);
        }catch(Exception e) {
            logger.error("getEmployee is called from Department Controller Exception",e);
        }
        return null;
    }

    public DepartmentController(WebClient.Builder loadBalancedWebClientBuilder) {
        this.webClient = loadBalancedWebClientBuilder.baseUrl("http://EMPLOYEE-SERVICE").build();
    }

    public Mono<Employee> getEmployeeDetails() {
        return this.webClient.get()
                .uri("/getEmployee")
                .retrieve()
                .bodyToMono(Employee.class);
    }
}