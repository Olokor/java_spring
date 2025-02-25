package com.CRUD_APP.demo.rest;

import com.CRUD_APP.demo.entity.Student;
import com.CRUD_APP.demo.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("system/student")
public class StudentRestController {
    private GenericService<Student> studentService;
    @Autowired
    public StudentRestController(GenericService<Student> studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/addstudent")
    public Student addStudent(@RequestBody Student student) {
        student.setId(0);
        Student newStudent = studentService.save(Student.class, student);
        return newStudent;
    }

    @PostMapping("/addstudents")
    public List<Student> addStudents(@RequestBody List<Student> students) {
//        students.forEach(student -> student.setId(0));
        students.forEach(student -> studentService.save(Student.class, student));
        return students;

    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.findAll(Student.class);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        Student student = studentService.findById(Student.class, id);
        if (student == null) {
            throw  new RuntimeException("Student not found");
        }
        return student;
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        Student updatedStudent = studentService.save(Student.class, student);
        return updatedStudent;
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        Student student = studentService.findById(Student.class, id);
        if (student == null) {
            throw  new RuntimeException("Student not found");
        }
        studentService.deleteById(Student.class, id);
    }

}
