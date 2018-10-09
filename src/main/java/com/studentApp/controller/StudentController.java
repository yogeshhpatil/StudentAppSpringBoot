package com.studentApp.controller;

import com.studentApp.entity.Student;
import com.studentApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/id={id}",method = RequestMethod.GET)
    public Student getStudentById(@PathVariable Integer id){
        System.out.println("id endpoint");
        return studentService.getStudentById(id);
    }

    @RequestMapping(value = "/name={name}" , method = RequestMethod.GET)
    public Student getStudentByName(@PathVariable String name){
        System.out.println("name endpoint");
        return studentService.getStudentByName(name);
    }

    @RequestMapping(value = "/course={course}", method = RequestMethod.GET)
    public Collection<Student> getStudentByCourse(@PathVariable String course){
        return studentService.getStudentByCourse(course);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteStudentById(@PathVariable Integer id){
        studentService.deleteStudentById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }
}
