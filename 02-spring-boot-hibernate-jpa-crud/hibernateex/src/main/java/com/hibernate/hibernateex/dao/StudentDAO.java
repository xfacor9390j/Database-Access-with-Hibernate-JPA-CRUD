package com.hibernate.hibernateex.dao;

import com.hibernate.hibernateex.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);
    List<Student> findAll();

    List<Student>findByFirstName(String firstname);
    void update(Student student);

    void delete(Integer id);
    int deleteAll();
}
