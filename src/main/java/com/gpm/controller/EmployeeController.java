package com.gpm.controller;


import com.gpm.models.Employee;
import com.gpm.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee){
       return this.employeeService.createEmployee(employee);
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        return this.employeeService.getAllEmployee();
    }

    @GetMapping("/employee/{empId}")
    public Employee getEmployeeById(@PathVariable Integer empId){
        return this.employeeService.getEmployeeById(empId);
    }

    @GetMapping("/employee/username/{username}")
    public Employee getEmployeeByUsername(@PathVariable String username){
        return this.employeeService.getEmployeeByUsername(username);
    }

    @PutMapping("/employee/{empId}")
    public Employee updateEmployee(@PathVariable Integer empId,@RequestBody Employee employee){
        return this.employeeService.updateEmployee(empId,employee);
    }

    @DeleteMapping("/employee/{empId}")
    public String deleteEmployee(@PathVariable Integer empId){
        this.employeeService.deleteEmployee(empId);
        return "Employee Successfully Deleted";
    }


}
