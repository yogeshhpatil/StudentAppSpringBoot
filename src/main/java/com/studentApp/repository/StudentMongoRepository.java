package com.studentApp.repository;

import com.studentApp.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMongoRepository extends MongoRepository<Student ,Integer> {
    List<Student> findByName(String name);
    List<Student> findByCourseIgnoreCase(String course);
}
