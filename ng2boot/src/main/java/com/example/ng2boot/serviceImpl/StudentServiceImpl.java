package com.example.ng2boot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ng2boot.DAO.StudentDAO;
import com.example.ng2boot.entity.Student;
import com.example.ng2boot.service.StudentService;


//service is to modify in future for many different dao layers -> customerDao, licenseDao
@Service
public class StudentServiceImpl implements StudentService {

	private StudentDAO studDao;
	
	@Autowired
	public StudentServiceImpl(StudentDAO theEmDao) {
		 this.studDao=theEmDao;
	}
	
	@Override
	@Transactional
	public List<Student> getAllStudents() {
		
		return studDao.getAllStudents();
	}

	@Override
	@Transactional
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return studDao.findById(id);
	}

	@Override
	@Transactional
	public void save(Student stud) {
		studDao.save(stud);
	}

	@Override
	@Transactional
	public void delete(int id) {
		studDao.delete(id);

	}

	@Override
	public Student getCourses(int id) {
		// TODO Auto-generated method stub
		return studDao.getCourses(id);
	}

}
