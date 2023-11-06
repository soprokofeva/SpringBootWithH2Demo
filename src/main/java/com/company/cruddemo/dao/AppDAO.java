package com.company.cruddemo.dao;

import com.company.cruddemo.entity.Instructor;
import com.company.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
}
