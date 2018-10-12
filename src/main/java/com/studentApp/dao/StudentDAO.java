package com.studentApp.dao;

import com.studentApp.entity.Student;

import java.util.Collection;
import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudents();

    Student getStudentById(Integer id);

    List<Student> getStudentByName(String name);

    List<Student> getStudentByCourse(String course);

    void deleteStudentById(Integer id);

    void updateStudent(Student student);

    void addStudent(Student student);
}
