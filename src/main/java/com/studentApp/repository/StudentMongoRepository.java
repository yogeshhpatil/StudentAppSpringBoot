package com.studentApp.repository;

import com.studentApp.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentMongoRepository extends MongoRepository<Student ,Integer> {
    Student findByName(String name);
    List<Student> findByCourseIgnoreCase(String course);
}
