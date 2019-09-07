package com.example.ng2boot.service;

import java.util.List;

import com.example.ng2boot.entity.Student;


public interface StudentService {
	
   public List<Student> getAllStudents();
   
   public Student getCourses(int id);
	
	public Student findById(int id);
	
	public void save(Student emp);
	
	public void delete(int id);

}
