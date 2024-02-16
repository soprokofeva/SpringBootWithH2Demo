package com.company.cruddemo;

import com.company.cruddemo.dao.AppDAO;
import com.company.cruddemo.entity.*;
import jakarta.persistence.NoResultException;
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
//            updateInstructorLastName(appDAO);
//            updateCourse(appDAO);
//            deleteCourse(appDAO);
//            createCourseWithReviews(appDAO);
//            findCourseWithReviews(appDAO);
//            deleteCourseWithReviews(appDAO);
//            createCourseAndStudents(appDAO);
//            findCourseWithStudents(appDAO);
//            findStudentWithCourses(appDAO);
            addcoursesForStudent(appDAO);
        };
    }

    private void addcoursesForStudent(AppDAO appDAO) {
        int id = 46;
        try {
            Student student = appDAO.findStudentWithCoursesByStudentId(id);
            Course course1 = new Course("Hot to understand statistic method");
            Course course2 = new Course("Data science");
            student.addCourse(course1);
            student.addCourse(course2);

            System.out.println("Student: " + student);
            System.out.println("Courses: " + student.getCourses());

            appDAO.update(student);
        } catch (NoResultException e) {
            System.out.println("There is no student with id: " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void findStudentWithCourses(AppDAO appDAO) {
        int id = 46;
        try {
            Student student = appDAO.findStudentWithCoursesByStudentId(id);
            System.out.println("Student: " + student);
            System.out.println("Courses: " + student.getCourses());
        } catch (NoResultException e) {
            System.out.println("There is no student with id: " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void findCourseWithStudents(AppDAO appDAO) {
        int id = 6;
        try {
            Course course = appDAO.findCourseWithStudentsByCourseId(id);
            System.out.println("Course: " + course);
            System.out.println("Students: " + course.getStudents());
        } catch (NoResultException e) {
            System.out.println("There is no course with id: " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createCourseAndStudents(AppDAO appDAO) {
        Course course = new Course("How to understand math");

        Student student1 = new Student("Bonnie", "Thunder", "bonniethunder@email.com");
        Student student2 = new Student("Elsa", "Frozen", "elsafrozen@email.com");
        Student student3 = new Student("Anna", "Frozen", "annafrozen@email.com");

        course.addStudent(student1);
        course.addStudent(student2);
        course.addStudent(student3);

        appDAO.save(course);
    }

    private void deleteCourseWithReviews(AppDAO appDAO) {
        int id = 5;
        appDAO.deleteCourseById(id);
    }

    private void findCourseWithReviews(AppDAO appDAO) {
        int id = 5;
        try {
            Course course = appDAO.findCourseWithReviewsByCourseId(id);
            System.out.println(course);
            System.out.println(course.getReviews());
        } catch (NoResultException e) {
            System.out.println("There is no course with id: " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createCourseWithReviews(AppDAO appDAO) {

        Course course1 = new Course("Psychological course");
        course1.addReview(new Review("How usefull information!"));
        course1.addReview(new Review("Thanks!"));
        course1.addReview(new Review("I hope it will help me"));

        System.out.println(course1);
        System.out.println(course1.getReviews());

        appDAO.save(course1);
    }

    private void deleteCourse(AppDAO appDAO) {
        int id = 4;
        appDAO.deleteCourseById(id);
    }

    private void updateCourse(AppDAO appDAO) {
        int id = 1;
        Course course = appDAO.findCourseById(id);
        if (course != null) {
            System.out.println(course);
            course.setTitle("TESTING COURSE");
            appDAO.updateCourse(course);
            System.out.println("The course has been updated");
        } else {
            System.out.println("There is no course with id: " + id);
        }
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
        int id = 6;
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
