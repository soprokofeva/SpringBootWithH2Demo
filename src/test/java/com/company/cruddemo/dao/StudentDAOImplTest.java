package com.company.cruddemo.dao;

import com.company.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentDAOImplTest {
    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private EntityManager entityManager;


    @Test
    @Transactional
    public void testStudentSameObject() {
        System.out.println("---------------------------Test has started-------------------------------------------------");
        Student student = new Student("TestName", "TestSurname", "test@test.com");
        studentDAO.save(student);
        System.out.println("Student has saved");
        String targetName = "TestSurname";

        Student st1 = studentDAO.findByLastName(targetName).get(0);
        System.out.println("Find student 1");
        Student st2 = studentDAO.findByLastName(targetName).get(0);
        System.out.println("Find student 2");

        assertSame(st1, st2);
        assertTrue(st1 == st2);
    }

    @Test
    public void testSameObjects() {
        System.out.println("---------------------------Test has started-------------------------------------------------");
        List<Student> st1 = studentDAO.findAll();
        System.out.println("Find student list 1");
        List<Student> st2 = studentDAO.findAll();
        System.out.println("Find student list 2");

        assertNotSame(st1, st2);
        assertFalse(st1 == st2);

    }

    @Test
    @Transactional
    public void testSessionNotEquals() {
        System.out.println("---------------------------Test has started-------------------------------------------------");
        Student student = new Student("TestName", "TestSurname", "test@test.com");
        studentDAO.save(student);
        System.out.println("Student has saved");
        int id = student.getId();

        entityManager.detach(student);
        System.out.println("Student object has detached");

        Student st1 = studentDAO.findById(id);
        System.out.println("Find student by same id");

        assertFalse(student == st1);
    }

}