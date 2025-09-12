package com.codejava.dynamodb.repository;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.codejava.dynamodb.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Employee save(Employee employee) {
        dynamoDBMapper.save(employee);
        return employee;
    }
}
