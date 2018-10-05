package com.studentApp.dao;

import com.studentApp.entity.Student;
import com.studentApp.repository.StudentMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
@Qualifier("StudentDAOMongo")
public class StudentDAOMongoDB implements StudentDAO {

    @Autowired
    StudentMongoRepository studentMongoRepository;

    @Override
    public Collection<Student> getAllStudents() {
        Iterable<Student> all = studentMongoRepository.findAll();
        List<Student> students =new ArrayList<>();
        if(all.iterator().hasNext()){
            all.forEach(students::add);
            return students;
        }
        return null;
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentMongoRepository.findOne(id);
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentMongoRepository.delete(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentMongoRepository.save(student);
    }

    @Override
    public void addStudent(Student student) {
        studentMongoRepository.save(student);
    }
}
