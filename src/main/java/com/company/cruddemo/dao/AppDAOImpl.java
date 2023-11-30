package com.company.cruddemo.dao;

import com.company.cruddemo.entity.Course;
import com.company.cruddemo.entity.Instructor;
import com.company.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

    EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        if (instructor != null) {
            entityManager.remove(instructor);
        }
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail detail = entityManager.find(InstructorDetail.class, id);
        if (detail != null) {
            detail.getInstructor().setInstructorDetail(null);
            entityManager.remove(detail);
        }
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :idParam", Course.class);
        query.setParameter("idParam", id);
        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i "
                                                                    + "JOIN FETCH i.courses "
                                                                    + "JOIN FETCH i.instructorDetail "
                                                                    + "where i.id = :idParam", Instructor.class);
        query.setParameter("idParam", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {
        entityManager.merge(instructor);
    }
}
