package com.example.ng2boot.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.ng2boot.entity.Course;
import com.example.ng2boot.entity.Student;
import com.example.ng2boot.service.StudentService;

@RestController
public class WebRestController {

	private StudentService studServ;

	public WebRestController(StudentService theStudServ) {
		this.studServ = theStudServ;
	}

	@GetMapping(path = "/api/courses/{stuId}")
	public ArrayList<Course> getFindEmploy(@PathVariable int stuId) {
		ArrayList<Course> list = new ArrayList<Course>();
		Student std=studServ.getCourses(stuId);
		if(std!=null) {
			list.addAll(std.getCourses());
		}
		return list;
	}
}
