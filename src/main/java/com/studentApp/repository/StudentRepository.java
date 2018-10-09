package com.studentApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.studentApp.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer>{
    Student findByName(String name);
    List<Student> findByCourseIgnoreCase(String course);
}
