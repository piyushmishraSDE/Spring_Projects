package com.example.learningjpa.jpademo;

import com.example.learningjpa.jpademo.entity.Course;
import com.example.learningjpa.jpademo.entity.Passport;
import com.example.learningjpa.jpademo.entity.Student;
import com.example.learningjpa.jpademo.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest(classes = JpademoApplication.class)
class JpademoApplicationTests {

	@Test
	void contextLoads() {
	}

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;

	@Autowired
	EntityManager em;

	// Session & Session Factory

	// EntityManager & Persistence Context
	// Transaction

	@Test
	@Transactional
	public void someTest(){
		Student student= em.find(Student.class,2001L);
		Passport passport = student.getPassport();

		passport.setNumber("IND6");

		student.setName("Tipu- Updated");
	}


	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {
		Student student = em.find(Student.class, 2001L);
		logger.info("student -> {}", student);
		logger.info("passport -> {}", student.getPassport());
	}

	@Test
	@Transactional
	public void retrievePassportAndAssociatedDetails() {
		Passport passport = em.find(Passport.class, 4001l);
		logger.info("passport -> {}", passport);
		logger.info("Student -> {}", passport.getStudent());
	}

	@Test
	@Transactional
	public void setAddressDetails() {
		Student student = em.find(Student.class, 20001L);
		//student.setAddress(new Address("No 101", "Some Street", "Hyderabad"));
		em.flush();
	}

	@Test
	@Transactional
	public void retrievePassportAndAssociatedStudent() {
		Passport passport = em.find(Passport.class, 40001L);
		logger.info("passport -> {}", passport);
		//logger.info("student -> {}", passport.getStudent());
	}

	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		Student student = em.find(Student.class, 20001L);

		logger.info("student -> {}", student);
		//logger.info("courses -> {}", student.getCourses());
	}

	@Test
	public void jpql_courses_without_students(){
		TypedQuery<Course> query = em.createQuery("Select c from Course c where c.students is empty",Course.class);
		List<Course> courseList = query.getResultList();

		logger.info("Courses without students-> {}", courseList);
	}


	@Test
	public void jpql_courses_with_atleast2_students(){
		TypedQuery<Course> query = em.createQuery("Select c from Course c where size(c.students) >= 2",Course.class);
		List<Course> courseList = query.getResultList();

		logger.info("Courses without students-> {}", courseList);
	}


	@Test
	public void jpql_courses_ordered_by_students(){
		TypedQuery<Course> query = em.createQuery("Select c from Course c order by  size(c.students) ",Course.class);
		List<Course> courseList = query.getResultList();

		logger.info("Courses without students-> {}", courseList);
	}

	@Test
	public void jpql_students_with_passport_in_a_certain(){
		TypedQuery<Student> query = em.createQuery("Select s from Student s where s.passport.number like '%IND%'",Student.class);
		List<Student> students = query.getResultList();

		logger.info("Courses without students-> {}", students);
	}

	@Test
	public void join(){
		Query query = em.createQuery("Select c,s from Course c JOIN c.students s");
		List<Object[]>  resultList = query.getResultList();

		logger.info("Results-> {}", resultList.size());
		for(Object[] result:resultList){
			logger.info("Course {} , Students {}",result[0],result[1]);

		}
	}

	@Test
	public void leftJoin(){
		Query query = em.createQuery("Select c,s from Course c LEFT JOIN c.students s");
		List<Object[]>  resultList = query.getResultList();

		logger.info("Results-> {}", resultList.size());
		for(Object[] result:resultList){
			logger.info("Course {} , Students {}",result[0],result[1]);

		}
	}

	@Test
	public void crossJoin(){
		Query query = em.createQuery("Select c,s from Course c , Student s");
		List<Object[]>  resultList = query.getResultList();

		logger.info("Results-> {}", resultList.size());
		for(Object[] result:resultList){
			logger.info("Course {} , Students {}",result[0],result[1]);

		}
	}

}
