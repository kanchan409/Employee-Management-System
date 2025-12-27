package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
    {
        Employee addEmployee= employeeService.addEmployee(employee);
        return ResponseEntity.ok(addEmployee);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
    {
        Employee updateEmployee=employeeService.updateEmployee(employee);
        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id)
    {
        String s =employeeService.deleteEmployee(id);
        return s;
    }


    @GetMapping("/employee/search/{name}")
    public List<Employee> searchEmployee(@PathVariable String name)
    {
        return employeeService.searchByName(name);
    }


}
