package com.hibernate.hibernateex.dao;

import com.hibernate.hibernateex.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOimpl implements StudentDAO{

    //define the field of entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection

    @Autowired
    public StudentDAOimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // impelment save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,1);
    }

    @Override
    public List<Student> findAll() {
        //create query
        TypedQuery <Student> thequery=entityManager.createQuery("From Student order by firstname asc",Student.class);

        //return query results
        return thequery.getResultList();
    }

    @Override
    public List<Student> findByFirstName(String firstname) {
        //create the querey
        TypedQuery<Student>thequery=entityManager.createQuery("From Student WHERE firstname=:theData",Student.class);

        //set the parameter
        thequery.setParameter("theData",firstname);

        //return result
        return thequery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //retive the student
        Student theStudent=entityManager.find(Student.class,id);

        //delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted=entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return numRowsDeleted;
    }


}
