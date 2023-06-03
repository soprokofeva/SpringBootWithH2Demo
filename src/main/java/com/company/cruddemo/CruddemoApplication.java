package com.company.cruddemo;

import com.company.cruddemo.dao.StudentDAO;
import com.company.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            createStudent(studentDAO);
            createStudents(studentDAO);
            readStudent(studentDAO);
            queryStudents(studentDAO);
            queryStudentsByLastName(studentDAO);
            updateStudentLastName(studentDAO);
        };
    }

    private void updateStudentLastName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByLastName("Pie");
        if (!students.isEmpty()) {
            Student student = students.get(0);
            System.out.println("Updating...");
            student.setLastName("Crazy");
            studentDAO.update(student);
            System.out.println("Updated student: " + student);
        }
    }

    private void queryStudentsByLastName(StudentDAO studentDAO) {
        List<Student> queryStudents = studentDAO.findByLastName("Begins");
        for (Student student : queryStudents) {
            System.out.println(student);
        }
    }

    private void queryStudents(StudentDAO studentDAO) {
        List<Student> queryStudents = studentDAO.findAll();
        for (Student student : queryStudents) {
            System.out.println(student);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Creating mew student");
        Student theStudent = new Student("Aslan", "Leo", "aslanleo@narnia.com");
        System.out.println("Saving the student: " + theStudent);
        studentDAO.save(theStudent);
        int id = theStudent.getId();
        System.out.println("Saved student. Id: " + id);

        System.out.println("Retrieving student by the id: " + id);
        Student foundStudent = studentDAO.findById(id);
        System.out.println("Found student: " + foundStudent);

    }

    private void createStudents(StudentDAO studentDAO) {
        Student theStudent = new Student("Bilbo", "Begins", "bbegins@middleEarth.com");
        Student theStudent2 = new Student("Harry", "Potter", "hpotter@hogwarts.com");
        Student theStudent3 = new Student("Pinkie", "Pie", "ppie@ponyville.com");

        System.out.println("Saving the students");

        studentDAO.save(theStudent);
        studentDAO.save(theStudent2);
        studentDAO.save(theStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating mew student");
        Student theStudent = new Student("Frodo", "Begins", "fbegins@middleEarth.com");
        System.out.println("Saving the student: " + theStudent);
        studentDAO.save(theStudent);
        System.out.println("Saved student. Id: " + theStudent.getId());
    }
}
