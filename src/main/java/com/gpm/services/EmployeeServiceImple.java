package com.gpm.services;

import com.gpm.exception.ResourceNotFoundException;
import com.gpm.models.Employee;
import com.gpm.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImple implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee createEmployee(Employee employee) {
        return this.employeeRepository.save(employee);

    }

    @Override
    public Employee getEmployeeById(Integer empId) {
        return this.employeeRepository.findById(empId).orElseThrow(()->new ResourceNotFoundException("Employee is Not in Database of this Emp Id"));
    }

    @Override
    public List<Employee> getAllEmployee() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Integer empId, Employee employee) {
       Employee employee1= this.employeeRepository.findById(empId).orElseThrow(()->new ResourceNotFoundException("Employee is Not in Database of this Emp Id"));
        employee1.setName(employee.getName());
        employee1.setEmail(employee.getEmail());
        employee1.setAddress(employee.getAddress());
        employee1.setDesignation(employee.getDesignation());
        employee1.setMobile(employee.getMobile());
        employee1.setDepartment(employee.getDepartment());
        employee1.setImage(employee.getImage());
        employee1.setPassword(employee.getPassword());

        return this.employeeRepository.save(employee1);

    }

    @Override
    public Employee getEmployeeByUsername(String username) {
       return this.employeeRepository.findByUsername(username).orElseThrow(()->new ResourceNotFoundException("Employee is Not found of this username"));
    }

    @Override
    public void deleteEmployee(Integer empId) {
        Employee employee1= this.employeeRepository.findById(empId).orElseThrow(()->new ResourceNotFoundException("Employee is Not in Database of this Emp Id"));
        this.employeeRepository.delete(employee1);

    }
}
