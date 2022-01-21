package com.globalexceptionhandlerwithtests.demo.controller;

import com.globalexceptionhandlerwithtests.demo.entity.Employee;
import com.globalexceptionhandlerwithtests.demo.service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/code")
public class EmployeeController {

    @Autowired
    private EmployeeServiceInterface employeeServiceInterface;

    @PostMapping("/save")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeServiceInterface.addEmployee(employee);
    }
}
