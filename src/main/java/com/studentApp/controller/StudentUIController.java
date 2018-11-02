package com.studentApp.controller;

import com.studentApp.entity.Student;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ui/student")
public class StudentUIController {

    RestTemplate restTemplate;

    public StudentUIController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String show(Model model){
        String uri = "http://localhost:8080/rest/students";

        restTemplate = new RestTemplate();

        ResponseEntity<List<Student>> listResponseEntity = restTemplate.exchange(uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Student>>() {});

        List<Student> studentList = listResponseEntity.getBody();

        if(studentList!=null)
            studentList.stream().forEach(System.out::println);

        if(studentList!=null){
            model.addAttribute("studentList",studentList);
        }else {
            model.addAttribute("errorMessage","Not Record Found");
        }
        return "home";
    }

    @GetMapping("/addstudent")
    public String addStudent(){
        return "addstudent";
    }

    @PostMapping
    public String addStudentToDb(@RequestParam String id,@RequestParam String name,
                                 @RequestParam String course, Model model){
        String uri = "http://localhost:8080/rest/students/"+id;

        restTemplate = new RestTemplate();

        ResponseEntity<Student> exchange = restTemplate.exchange(uri, HttpMethod.GET, null,
                Student.class);

        Student student = new Student(Integer.valueOf(id),name,course);

        if(exchange.getBody()==null){
            uri = "http://localhost:8080/rest/students";

            Student result = restTemplate.postForObject( uri, student, Student.class);

            model.addAttribute("errorMessage",student.getId()+" is added");

            uri = "http://localhost:8080/rest/students";
            ResponseEntity<List<Student>> listResponseEntity = restTemplate.exchange(uri, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Student>>() {});

            model.addAttribute("studentList",listResponseEntity.getBody());

            return "home";
        }

        model.addAttribute("student",student);
        model.addAttribute("errorMessage",id+" is already present choose another one");
        return "addstudent";
    }

    @GetMapping("/edit/{id}")
    public String editDetails(@PathVariable String id,Model model){
        String uri = "http://localhost:8080/rest/students/"+id;

        restTemplate = new RestTemplate();

        ResponseEntity<Student> exchange = restTemplate.exchange(uri, HttpMethod.GET, null,
                Student.class);

        model.addAttribute("student",exchange.getBody());

        return "editstudent";
    }

    @PostMapping("/{id}")
    public String updateDetails(@PathVariable String id, @RequestParam String name,
            @RequestParam String course, Model model) {


        String uri = "http://localhost:8080/rest/students/{id}";

        Map<String,String> params = new HashMap<String, String>();
        params.put("id", id);

        Student student = new Student(Integer.valueOf(id),name,course);

        restTemplate = new RestTemplate();
        restTemplate.put( uri, student, params);

        uri = "http://localhost:8080/rest/students";
        ResponseEntity<List<Student>> listResponseEntity = restTemplate.exchange(uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Student>>() {});

        model.addAttribute("studentList",listResponseEntity.getBody());
        model.addAttribute("errorMessage",student.getId()+" is updated");

        return "home";
    }

    @GetMapping("/delete/{id}")
    public String deletDetails(@PathVariable String id,Model model){
        String uri = "http://localhost:8080/rest/students/{id}";

        restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<String, String>();

        params.put("id", id);

        restTemplate.delete(uri,params);

        uri = "http://localhost:8080/rest/students";
        ResponseEntity<List<Student>> listResponseEntity = restTemplate.exchange(uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Student>>() {});

        model.addAttribute("studentList",listResponseEntity.getBody());
        model.addAttribute("errorMessage",id+" is deleted");

        return "home";
    }

    /*@GetMapping(value = "/id={id}")
    public String getStudentById(@PathVariable int id, Model model) {

        String uri = "http://localhost:8080/rest/students/id="+id;

        restTemplate = new RestTemplate();
        Student student = restTemplate.getForObject(uri, Student.class);

        if(student!=null){
            List<Student> studentList = new ArrayList<>();
            studentList.add(student);
            model.addAttribute("studentList",studentList);
        }else {
            model.addAttribute("errorMessage","Not Record Found");
        }
        return "home";
    }*/

}
