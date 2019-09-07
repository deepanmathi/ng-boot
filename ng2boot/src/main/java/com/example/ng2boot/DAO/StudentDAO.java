package com.example.ng2boot.DAO;

import java.util.List;

import com.example.ng2boot.entity.Student;

public interface StudentDAO {
	
	public List<Student> getAllStudents();
	
	public Student getCourses(int id);
	
	public Student findById(int id);
	
	public void save(Student emp);
	
	public void delete(int id);
	

}
