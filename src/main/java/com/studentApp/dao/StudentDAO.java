package com.studentApp.dao;

import com.studentApp.entity.Student;

import java.util.Collection;

public interface StudentDAO {
    Collection<Student> getAllStudents();

    Student getStudentById(Integer id);

    Student getStudentByName(String name);

    Collection<Student> getStudentByCourse(String course);

    void deleteStudentById(Integer id);

    void updateStudent(Student student);

    void addStudent(Student student);
}
