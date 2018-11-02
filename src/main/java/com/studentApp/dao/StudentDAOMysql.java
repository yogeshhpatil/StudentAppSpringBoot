package com.studentApp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.studentApp.entity.Student;
import com.studentApp.repository.StudentMySqlRepository;

@Component
@Qualifier("StudentDAOMysql")
public class StudentDAOMysql implements StudentDAO {

	private StudentMySqlRepository repository;

	public StudentDAOMysql(StudentMySqlRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Student> getAllStudents() {
		Iterable<Student> all = repository.findAll();
		List<Student> students =new ArrayList<>();
		if(all.iterator().hasNext()){
			all.forEach(students::add);
			return students;
		}
		return null;
	}

	@Override
	public Student getStudentById(Integer id) {
		Optional<Student> byId = repository.findById(id);
		if(byId.isPresent()){
			return byId.get();
		}
		return null;
	}

	@Override
	public List<Student> getStudentByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public List<Student> getStudentByCourse(String course) {
		return repository.findByCourseIgnoreCase(course);
	}

	@Override
	public void deleteStudentById(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public void updateStudent(Student student) {
		repository.save(student);
	}

	@Override
	public void addStudent(Student student) {
		repository.save(student);
	}
}
