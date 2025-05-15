package com.sbr.student_based_repository.service;

import com.sbr.student_based_repository.Exception.StudentAlreadyExistException;
import com.sbr.student_based_repository.Exception.StudentNotFoundException;
import com.sbr.student_based_repository.model.Student;
import com.sbr.student_based_repository.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements StudentServiceInterface{

    private final StudentRepository studentRepository;
    @Override
    public Student addStudent(Student student) {
        if (studentAlreadyExist(student.getEmail())){
            throw new StudentAlreadyExistException(student.getEmail()+" Already Exist");
        }

        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("no student found with id "+id));
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        return studentRepository.findById(id).map(student1 -> {
            student1.setFirstName(student.getFirstName());
            student1.setLastName(student.getLastName());
            student1.setEmail(student.getEmail());
            return studentRepository.save(student1);
        }).orElseThrow(()-> new StudentNotFoundException("Student notfound"));
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("no student found with id "+id);
        }
        studentRepository.deleteById(id);
    }
    private boolean studentAlreadyExist(String email) {
        return studentRepository.findByEmail(email).isPresent();
    }
}
