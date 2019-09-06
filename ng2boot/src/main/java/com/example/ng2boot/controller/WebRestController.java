package com.example.ng2boot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ng2boot.model.User;
 
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class WebRestController {
	
	 @RequestMapping("/api/hi")
	  public ArrayList<User> hi() {
		 System.out.println("in");
		 ArrayList<User> list=new ArrayList<User>();
		 list.add(new User("1", "deepan", "khgjhg", "jgfjj"));
		return list;
	  }
}
