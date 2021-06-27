package com.example.learningjpa.jpademo;

import com.example.learningjpa.jpademo.entity.Employee;
import com.example.learningjpa.jpademo.entity.FullTimeEmployee;
import com.example.learningjpa.jpademo.entity.PartTimeEmployee;
import com.example.learningjpa.jpademo.entity.Review;
import com.example.learningjpa.jpademo.repository.CourseRepository;
import com.example.learningjpa.jpademo.repository.EmployeeRepository;
import com.example.learningjpa.jpademo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpademoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpademoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//studentRepository.saveStudentWithPassport();
		/*List<Review> reviews = new ArrayList<>();
		reviews.add(new Review("5","Test from COmmandLine"));
		courseRepository.addReviewsForCourse(1003L,reviews);*/
		//studentRepository.insertStudentAndCourse();
		/*employeeRepository.insert(new PartTimeEmployee("Jill",new BigDecimal("50")));
		employeeRepository.insert(new FullTimeEmployee("Jack",new BigDecimal("10000")));
		logger.info("All Employees ->{}",employeeRepository.retrieveAllPartTimeEmployees());
		logger.info("All Employees ->{}",employeeRepository.retrieveAllFullTimeEmployees());*/
	}
}
