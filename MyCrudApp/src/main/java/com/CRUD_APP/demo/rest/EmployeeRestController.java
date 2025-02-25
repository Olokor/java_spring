package com.CRUD_APP.demo.rest;

import com.CRUD_APP.demo.entity.MyEmployee;
import com.CRUD_APP.demo.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("system/employee")
public class EmployeeRestController {
    private GenericService<MyEmployee> employeeService;
    @Autowired
    public EmployeeRestController(GenericService<MyEmployee> employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public List<MyEmployee> getAllEmployees() {
        return employeeService.findAll(MyEmployee.class);
    }
    @GetMapping("{id}")
    public MyEmployee getEmployee(@PathVariable int id) {
        MyEmployee employee = employeeService.findById(MyEmployee.class, id);
        if (employee == null) {
            throw new RuntimeException("Employee with id " + id + " not found");
        }
        return employee;
    }

    @PostMapping("/addemployee")
    public MyEmployee addEmployee(@RequestBody MyEmployee employee) {
        employee.setId(0);
        MyEmployee newEmployee = employeeService.save(MyEmployee.class, employee);
        return newEmployee;
    }

    @PostMapping("/addemployees")
    public List<MyEmployee> addEmployees(@RequestBody List<MyEmployee> employees) {
        employees.forEach(employee -> employeeService.save(MyEmployee.class, employee));
        return employees;
    }

    @PutMapping("/employeeupdate")
    public MyEmployee updateEmployee(@RequestBody MyEmployee employee) {
        MyEmployee updatedEmployee = employeeService.save(MyEmployee.class, employee);
        return updatedEmployee;
    }

    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteById(MyEmployee.class, id);
    }
}
