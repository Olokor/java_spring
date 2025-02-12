package com.love2code.cruddemo.dao;

import com.love2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDaoInterface { //student data access object interface

    void save(Student student);

    Student getStudentById(int id);

    List<Student> getAllStudents();

    void updateStudent(Student student);

    void deleteStudent(int id);

    int deleteAllStudents();
}
