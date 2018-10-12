package com.studentApp.controller;

import com.studentApp.entity.Student;
import com.studentApp.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/student")
public class StudentRestController {

    private StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping(value = "/id={id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @GetMapping(value = "/name={name}")
    public List<Student> getStudentByName(@PathVariable String name){
        return studentService.getStudentByName(name);
    }

    @GetMapping(value = "/course={course}")
    public List<Student> getStudentByCourse(@PathVariable String course){
        return studentService.getStudentByCourse(course);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteStudentById(@PathVariable(value = "id") int id){
        studentService.deleteStudentById(id);
    }

    @PutMapping(value = "/{id}")
    public void updateStudent(@PathVariable(value = "id") int id,@RequestBody Student student){
        if(id==student.getId()){
            studentService.updateStudent(student);
            return;
        }
        System.out.println("Id Mismatch");
    }

    @PostMapping()
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }
}
