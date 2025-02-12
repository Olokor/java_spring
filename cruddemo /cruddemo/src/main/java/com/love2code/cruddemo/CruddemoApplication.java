package com.love2code.cruddemo;

import com.love2code.cruddemo.dao.StudentDao;
import com.love2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner ->{
			createStudent(studentDao);
			createMultipleStudent(studentDao);
//			readStudent(studentDao);
//			getAllStudents(studentDao);
//			updateStudent(studentDao);
//			deleteStudent(studentDao);
//			deleteAllStudent(studentDao);
		};
	}

	private void deleteAllStudent(StudentDao studentDao) {
		int numRows = studentDao.deleteAllStudents();
		System.out.println("number of rows deleted "+numRows);
	}

	private void deleteStudent(StudentDao studentDao) {
//		Student student = studentDao.getStudentById(2);
		studentDao.deleteStudent(2);
	}

	private void updateStudent(StudentDao studentDao) {
		int studentId = 1;
		Student myStudent = studentDao.getStudentById(studentId);
		myStudent.setFirstName("amaka");
		studentDao.updateStudent(myStudent);
		System.out.println(myStudent);
	}

	private void getAllStudents(StudentDao studentDao) {
		List<Student> students = studentDao.getAllStudents();
		students.forEach(student -> System.out.println(student));
	}

	private void readStudent(StudentDao studentDao) {
		System.out.println("my student is "+studentDao.getStudentById(1));
	}

	private void createMultipleStudent(StudentDao studentDao) {
		List<Student> students = new ArrayList<>(List.of(
				new Student("favour", "olokor", "olokorfavour@gmail.com"),
				new Student("james", "aleh", "jamesaleh@gmail.com"),
				new Student("blessing", "yakubu", "yakubublessing@gmail.com")
		)

		);
		students.forEach(student -> studentDao.save(student));
	}

	private void createStudent(StudentDao studentDao) {
		System.out.println("cretaing student...");
		Student tempStudent = new Student("wisdom", "olokor", "olokorwisdom15@gmail.com");
		studentDao.save(tempStudent);
	}
}
