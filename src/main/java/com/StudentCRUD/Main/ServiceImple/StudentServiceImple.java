package com.StudentCRUD.Main.ServiceImple;

import java.util.List;
import org.springframework.stereotype.Service;
import com.StudentCRUD.Main.Model.Student;
import com.StudentCRUD.Main.Dao.StudentDao;
import com.StudentCRUD.Main.Service.StudentService;

@Service
public class StudentServiceImple implements StudentService {

	private StudentDao studeDao = new StudentDao();
	
	@Override
	public List<Student> studentlist() {
		return studeDao.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		return studeDao.findById(id);
	}

	@Override
	public Student addStudent(Student s1) {
		return studeDao.save(s1);
	}

	@Override
	public Student updateStudent(int id, Student s1) {
		return studeDao.update(id, s1);
	}

	@Override
	public void delStudent(int id) {
			studeDao.delete(id);
	}

}
