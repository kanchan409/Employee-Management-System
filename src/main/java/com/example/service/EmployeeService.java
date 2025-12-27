package com.example.service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    @Transactional
    public Employee addEmployee(Employee employee)
    {
        Employee addRecord=employeeRepository.save(employee);
        return addRecord;
    }

    @Transactional
    public Employee updateEmployee(Employee employee)
    {
        Employee updateEmployee=employeeRepository.save(employee);
        return updateEmployee;
    }

    public String deleteEmployee(int id)
    {
        if(employeeRepository.findById(id).isPresent())
        {
            employeeRepository.deleteById(id);
            return "Employee Deleted Sucessfully..";
        }else
        {
            return "Employee Not Found..";
        }
    }

    public List<Employee> searchByName(String name)
    {
        return employeeRepository.findByName(name);
    }
}
