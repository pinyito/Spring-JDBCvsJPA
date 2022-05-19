package com.eriaothienopinyi.jpahibernate.repository;

import com.eriaothienopinyi.jpahibernate.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CourseRepository {
    @Autowired
    private EntityManager em;

    public Course findById(Long id){
        return em.find(Course.class, id);
    }
//    public Course save(Course course){
//        return null;
//    }
//    public void deleteById(Long id){
//
//    }

}
