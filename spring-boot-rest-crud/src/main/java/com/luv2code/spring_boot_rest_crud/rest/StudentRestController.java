package com.luv2code.spring_boot_rest_crud.rest;

import com.luv2code.spring_boot_rest_crud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> students;
    @PostConstruct
    public void init() {
        students = new ArrayList<>(
                List.of(
                        new Student("charlse", "edeki"),
                        new Student("favour", "olokor"),
                        new Student("david", "davis"),
                        new Student("moses", "oghene"),
                        new Student("blessing", "aniebo")
                )
        );
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return this.students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {

        if ((studentId > students.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student not found - " + studentId);
        }
        return this.students.get(studentId);
    }


}
