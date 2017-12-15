package com.studentApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.studentApp.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer>{

}
