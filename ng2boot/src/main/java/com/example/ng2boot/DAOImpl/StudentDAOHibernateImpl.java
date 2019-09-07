package com.example.ng2boot.DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.ng2boot.DAO.StudentDAO;
import com.example.ng2boot.entity.Course;
import com.example.ng2boot.entity.Student;

@Repository
public class StudentDAOHibernateImpl implements StudentDAO {

	private EntityManager entityManager;

	@Autowired
	public StudentDAOHibernateImpl(EntityManager theentityManager) {
		this.entityManager = theentityManager;
	}

	@Override
	public List<Student> getAllStudents() {
		return null;
	}

	@Override
	public Student findById(int id) {
		return null;
	}

	@Override
	public void save(Student emp) {
	}

	@Override
	public void delete(int id) {
	}

	@Override
	public Student getCourses(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Student emp = currentSession.get(Student.class, id);
		if (emp != null) {
			for (int i = 0; i < emp.getCourses().size(); i++) {
				Course crse = emp.getCourses().get(i);
				Query qry = currentSession
						.createSQLQuery(
								"select grade from course_student where course_id=:crseId and  student_id=:studId")
						.setParameter("studId", id).setParameter("crseId", crse.getId());
				String gr = (String) qry.uniqueResult();
				emp.getCourses().get(i).setGrade(gr);
			}
		}
		return emp;
	}

}
