package com.studentApp.dao;

import com.studentApp.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
@Qualifier("StudentDAOImpl")
public class StudentDAOImpl implements StudentDAO {
    private static Map<Integer,Student> students;

    static {
        students=new HashMap<Integer, Student>(){
            {
                put(1,new Student(1,"yogesh","computer"));
                put(2,new Student(2,"nilesh","mechanical"));
                put(3,new Student(3,"vishal","electrical"));
            }
        };
    }

    @Override
    public Collection<Student> getAllStudents(){
        return students.values();
    }

    @Override
    public Student getStudentById(Integer id){
        return this.students.get(id);
    }


    @Override
    public void deleteStudentById(Integer id) {
        this.students.remove(id);
    }

    @Override
    public void updateStudent(Student student){
        Student student1=students.get(student.getId());
        student1.setCourse(student.getCourse());
        student1.setName(student.getName());
        students.put(student.getId(),student1);
    }

    @Override
    public void addStudent(Student student) {
        this.students.put(student.getId(),student);
    }
}
