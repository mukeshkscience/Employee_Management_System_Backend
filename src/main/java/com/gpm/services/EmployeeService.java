package com.gpm.services;

import com.gpm.models.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);
    Employee getEmployeeById(Integer empId);
    List<Employee> getAllEmployee();
    Employee updateEmployee(Integer empId,Employee employee);
    Employee getEmployeeByUsername(String username);
    void deleteEmployee(Integer empId);
}
