package com.luv2code.springboot.Employee_api_application.service;

import com.luv2code.springboot.Employee_api_application.entity.Employee;

import java.util.List;

public interface EmployeeServiceInterface {
    List<Employee> getAllEmployees();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
