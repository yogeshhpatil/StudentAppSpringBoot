package com.studentApp.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.studentApp.entity.Student;
import com.studentApp.repository.StudentRepository;

@Repository
@Qualifier("StudentDAOMysql")
public class StudentDAOMysql implements StudentDAO {

	@Autowired
	private StudentRepository repository;
	
	@Override
	public Collection<Student> getAllStudents() {
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
//		return repository.findOne(id);
		Optional<Student> byId = repository.findById(id);
		if(byId.isPresent())
			return byId.get();
		return null;
	}

	@Override
	public Student getStudentByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public Collection<Student> getStudentByCourse(String course) {
		return repository.findByCourseIgnoreCase(course);
	}

	@Override
	public void deleteStudentById(Integer id) {
//		repository.delete(id);
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
