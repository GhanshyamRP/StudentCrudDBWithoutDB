package com.StudentCRUD.Main.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.StudentCRUD.Main.Model.Student;

@Service
public interface StudentService {
	
	List<Student> studentlist();
	Student getStudentById(int id);
	Student addStudent(Student s1);
	Student updateStudent(int id, Student s1);
	void delStudent(int id);
	

}
