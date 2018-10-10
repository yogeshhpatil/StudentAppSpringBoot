package com.studentApp;

import com.studentApp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.data.mongodb.repository.MongoRepository;

@SpringBootApplication
@EnableConfigServer
public class StudentApp implements CommandLineRunner {

    MongoRepository repository;

    public StudentApp(MongoRepository repository){
        this.repository=repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(StudentApp.class,args);
    }

    @Override
    public void run(String... strings) throws Exception {
        //Insert sample Data for first run :: will insert into mongo db

        if(repository!=null){
            Student student1 = new Student(1,"XYZ1","ABC1");
            Student student2 = new Student(2,"XYZ2","ABC2");
            Student student3 = new Student(3,"XYZ3","ABC3");

            repository.save(student1);
            repository.save(student2);
            repository.save(student3);
        }
    }
}

