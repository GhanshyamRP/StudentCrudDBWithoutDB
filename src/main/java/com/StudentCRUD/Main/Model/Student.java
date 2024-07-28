package com.StudentCRUD.Main.Model;


public class Student {
	
	private int id;
	private String name;
	private int age;
	private int rollNo;
	private String grade;
	
	
	
	public Student() {
	}

	public Student(int id, String name, int age, int rollNo, String grade) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.rollNo = rollNo;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "id=" + id +", name=" + name + ", age=" + age + ", rollNo=" + rollNo + ", grade=" + grade;
	}
	
	
	public static Student fromString(String str) {
        String[] parts = str.split(",");
        return new Student(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), parts[4]);
    }

	public String  addtofile(int c, Student s1) {
		return c+","+s1.name+","+s1.age+","+s1.rollNo+","+s1.grade;
		
	}
	

}
