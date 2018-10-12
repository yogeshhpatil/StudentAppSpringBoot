package com.studentApp.dao;

import com.studentApp.entity.Student;
import com.studentApp.repository.StudentMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
@Qualifier("StudentDAOMongo")
public class StudentDAOMongoDB implements StudentDAO {

    StudentMongoRepository studentMongoRepository;

    public StudentDAOMongoDB(StudentMongoRepository studentMongoRepository) {
        this.studentMongoRepository = studentMongoRepository;
    }

    @Override
    public List<Student> getAllStudents() {
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
        Optional<Student> byId = studentMongoRepository.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }
        return null;
    }

    @Override
    public List<Student> getStudentByName(String name) {
        return studentMongoRepository.findByName(name);
    }

    @Override
    public List<Student> getStudentByCourse(String course) {
        return studentMongoRepository.findByCourseIgnoreCase(course);
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentMongoRepository.deleteById(id);
//        studentMongoRepository.delete(id);
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
