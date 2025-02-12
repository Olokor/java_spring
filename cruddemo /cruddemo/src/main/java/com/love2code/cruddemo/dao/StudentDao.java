package com.love2code.cruddemo.dao;

import com.love2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // this gives us access to jdbc transction between object and database table
public class StudentDao implements StudentDaoInterface{ //student data access object

    private EntityManager entityManager;
    @Autowired
    public StudentDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Transactional
    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student getStudentById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> getAllStudents() {
        TypedQuery<Student> querySet = entityManager.createQuery("from Student order by firstName", Student.class);
        return querySet.getResultList();
    }

    @Transactional
    @Override
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Transactional
    @Override
    public void deleteStudent(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Transactional
    @Override
    public int deleteAllStudents() {

        return entityManager.createQuery("Delete from Student").executeUpdate();
    }


}
