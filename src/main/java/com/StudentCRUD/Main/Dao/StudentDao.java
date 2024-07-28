package com.StudentCRUD.Main.Dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.StudentCRUD.Main.Model.Student;


public class StudentDao {
	
	private final String FILE_PATH = "students.txt";
	private int count = 0;

	public List<Student> findAll() {
		 List<Student> students = new ArrayList<>();
	        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                students.add(Student.fromString(line));
	            }
	        } catch (IOException e){
	            e.printStackTrace();
	        }
	        return students;
	}
	
	public int findcount() {
	        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
	            
	            while ( reader.readLine() != null){
	                count++;
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return count;
	}
	
	public Student findById(int id) {
	    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	        	Student s  =Student.fromString(line);
	        	if(s.getId()==id) {
	        		return s;
	        	}
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	public Student save(Student s1) {
		 try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
			 int c = findcount()+1;
	            writer.write(s1.addtofile(c,s1));
	            writer.newLine();
	        } catch (IOException e){
	            e.printStackTrace();
	        }
		return s1;
	}

	public Student update(int id, Student s1) {
		  Student s2=null;
	        try {
	            List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
	            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
	                for (String line : lines) {
	                    s2= Student.fromString(line);
	                    System.out.println(s1.toString());
	                    if (s2.getId() == id) {
	                    	System.out.println("Student found");
	                    	if(s1.getName()!=null) {
	                			s2.setName(s1.getName());
	                		}
	                		if(s1.getAge() != 0) {
	                			s2.setAge(s1.getAge());
	                		}
	                		if(s1.getGrade() != null) {
	                			s2.setGrade(s1.getGrade());
	                		}
	                		if(s1.getRollNo() != 0) {
	                			s2.setRollNo(s1.getRollNo());
	                		}
	                        writer.write(s1.addtofile(id, s2));
	                    } else {
	                        writer.write(line);
	                    }
	                    writer.newLine();
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return s2;
	    }
	  
	public void delete(int id) {
		 try {
	            List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
	            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
	                for (String line : lines) {
	                    Student student = Student.fromString(line);
	                    if (student.getId() != id) {
	                        writer.write(line);
	                        writer.newLine();
	                    }
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}

}
