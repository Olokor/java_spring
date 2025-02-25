package com.luv2code.springboot.Employee_api_application.dao;

import com.luv2code.springboot.Employee_api_application.entity.Employee;

import java.util.List;

public interface EmployeeDaoInterface {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
