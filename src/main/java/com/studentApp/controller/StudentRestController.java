package com.studentApp.controller;

import com.studentApp.entity.Student;
import com.studentApp.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/students")
public class StudentRestController {

    private StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @GetMapping(params = "name")
    public List<Student> getStudentByName(@RequestParam String name){
        return studentService.getStudentByName(name);
    }

    @GetMapping(params = "course")
    public List<Student> getStudentByCourse(@RequestParam String course){
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
