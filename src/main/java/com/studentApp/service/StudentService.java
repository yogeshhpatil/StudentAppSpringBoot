package com.studentApp.service;

import com.studentApp.dao.StudentDAO;
import com.studentApp.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class StudentService {

    @Autowired
    @Qualifier("StudentDAOImpl")
    private StudentDAO studentDAO;

    public Collection<Student> getAllStudents(){
        return studentDAO.getAllStudents();
    }

    public Student getStudentById(Integer id){
        return this.studentDAO.getStudentById(id);
    }

    public void deleteStudentById(Integer id) {
        this.studentDAO.deleteStudentById(id);
    }

    public void updateStudent(Student student){
        studentDAO.updateStudent(student);
    }

    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }
}
