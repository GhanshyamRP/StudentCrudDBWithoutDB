package com.StudentCRUD.Main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentCRUD.Main.Model.Student;
import com.StudentCRUD.Main.ServiceImple.StudentServiceImple;

@RestController
@RequestMapping("stud")
public class StudentController {
	
	@Autowired
	StudentServiceImple studServ;
	
	@GetMapping("list")
	public ResponseEntity<List<Student>> getstudlist() {
		List<Student> studlist = studServ.studentlist();
		return new ResponseEntity<List<Student>>(studlist, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Student> getstudbyId (@PathVariable int id){
		Student s = studServ.getStudentById(id);
		return new ResponseEntity<Student>(s, HttpStatus.CREATED);
	}
	
	@PostMapping("add")
	public ResponseEntity<Student> poststud(@RequestBody Student s) {
		Student s1 = studServ.addStudent(s);
		return new ResponseEntity<Student>(s1, HttpStatus.CREATED);
	}
	
	@PutMapping("update/{id}")
	public  ResponseEntity<Student>  updateStud(@PathVariable int id, @RequestBody Student s) {
		Student s1 = studServ.updateStudent(id, s);
		return new ResponseEntity<Student>(s1, HttpStatus.OK);
	}
	
	@DeleteMapping("del/{id}")
	public ResponseEntity<String> delStud(@PathVariable int id) {
		studServ.delStudent(id);
		return new ResponseEntity<String>("Student Record Deleted...!", HttpStatus.OK);
	}
}
