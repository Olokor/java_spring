package com.sbr.student_based_repository.service;

import com.sbr.student_based_repository.model.Student;

import java.util.List;

public interface StudentServiceInterface {
    Student addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student updateStudent(Student student, Long id);
    void deleteStudent(Long id);
}
