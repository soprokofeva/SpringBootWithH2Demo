package com.company.cruddemo;

import com.company.cruddemo.dao.AppDAO;
import com.company.cruddemo.dao.StudentDAO;
import com.company.cruddemo.entity.Instructor;
import com.company.cruddemo.entity.InstructorDetail;
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
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
            createInstructor(appDAO);
        };
    }

    private void createInstructor(AppDAO appDAO) {
        Instructor instructor = new Instructor(
                "Albus",
                "Dumbledore",
                "albusdumbledore@hogwarts.com");

        InstructorDetail detail = new InstructorDetail(
                "https://www.youtube.com/hogwarts_school",
                "Magic");

        instructor.setInstructorDetail(detail);
        appDAO.save(instructor);

        Instructor instructor2 = new Instructor(
                "Meow",
                "Fixer",
                "meowfixer@fixfixmeow.com");

        InstructorDetail detail2 = new InstructorDetail(
                "https://www.youtube.com/fix_fix_meow_fix_it_now",
                "Developer's paws");

        instructor2.setInstructorDetail(detail2);
        appDAO.save(instructor2);
    }

}
