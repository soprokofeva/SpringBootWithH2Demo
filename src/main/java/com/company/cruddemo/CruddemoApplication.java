package com.company.cruddemo;

import com.company.cruddemo.dao.AppDAO;
import com.company.cruddemo.entity.Course;
import com.company.cruddemo.entity.Instructor;
import com.company.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
//            createInstructor(appDAO);
//            findInstructorById(appDAO);
//            deleteInstructorById(appDAO);
//            findInstructorDetailById(appDAO);
//            deleteInstructorDetailById(appDAO);

//            createInstructorWithCourses(appDAO);
//            findCoursesForInstructor(appDAO);
            updateInstructorLastName(appDAO);
        };
    }

    private void updateInstructorLastName(AppDAO appDAO) {
        int id = 6;
        Instructor instructor = appDAO.findInstructorById(id);
        if (instructor != null) {
            System.out.println("Instructor with the id " + id + " exists");
            instructor.setLastName("TEST");
            appDAO.updateInstructor(instructor);

        } else {
            System.out.println("There is no instructor with id " + id);
        }
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int id = 6;
        Instructor instructor = appDAO.findInstructorByJoinFetch(id);
        if (instructor != null) {
            System.out.println("Instructor with the id " + id + " exists");
            System.out.println(instructor);
            System.out.println("Instructor's courses: " + instructor.getCourses());
        } else {
            System.out.println("There is no instructor with id " + id);
        }
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
//        Instructor instructor = new Instructor(
//                "Pinkie",
//                "Pie",
//                "pinkiepie@eqwestria.com");
//
//        InstructorDetail detail = new InstructorDetail(
//                "https://www.youtube.com/eqwestria_pinkie",
//                "Fun");
//        instructor.setInstructorDetail(detail);
//
//        Course courseP1 = new Course("Friendship is fun");
//        Course courseP2 = new Course("Make more fun");
//        instructor.addCourse(courseP1);
//        instructor.addCourse(courseP2);
//        appDAO.save(instructor);

        Instructor instructor2 = new Instructor(
                "Twilight",
                "Sparkle",
                "twilightsparkle@eqwestria.com");

        InstructorDetail detail2 = new InstructorDetail(
                "https://www.youtube.com/eqwestria_twilight",
                "Magic");
        instructor2.setInstructorDetail(detail2);
        Course courseT1 = new Course("Friendship is magic");
        Course courseT2 = new Course("Make more magic");
        instructor2.addCourse(courseT1);
        instructor2.addCourse(courseT2);
        appDAO.save(instructor2);
    }

    private void deleteInstructorDetailById(AppDAO appDAO) {
        int id = 4;
        appDAO.deleteInstructorDetailById(id);
    }

    private void findInstructorDetailById(AppDAO appDAO) {
        int id = 1;
        InstructorDetail iDetail = appDAO.findInstructorDetailById(id);
        if (iDetail != null) {
            System.out.println(iDetail);
            System.out.println(iDetail.getInstructor());
        } else {
            System.out.println("There is no instructor detail with id " + id);

        }
    }

    private void deleteInstructorById(AppDAO appDAO) {
        int id = 2;
        appDAO.deleteInstructorById(id);
    }

    private void findInstructorById(AppDAO appDAO) {
        int id = 1;
        Instructor instructor = appDAO.findInstructorById(id);
        if (instructor != null) {
            System.out.println(instructor);
            System.out.println(instructor.getInstructorDetail());
        } else {
            System.out.println("There is no instructor with id " + id);
        }
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
