package com.globalexceptionhandlerwithtests.demo.service;

import com.globalexceptionhandlerwithtests.demo.entity.Employee;
import com.globalexceptionhandlerwithtests.demo.entity.Name;
import com.globalexceptionhandlerwithtests.demo.exception.EmptyInputException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements EmployeeServiceInterface{

    @Override
    public Employee addEmployee(Employee employee) {
        if(employee.getName().getFirstName().isEmpty() || employee.getName().getFirstName().length()==0) {
            throw new EmptyInputException("first name is missing");
        }
        return new Employee(employee.getId(), new Name(employee.getName().getFirstName(), employee.getName().getLastName()));
    }
}
