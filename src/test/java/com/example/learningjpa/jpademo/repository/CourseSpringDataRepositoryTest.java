package com.example.learningjpa.jpademo.repository;

import com.example.learningjpa.jpademo.JpademoApplication;
import com.example.learningjpa.jpademo.entity.Course;
import com.example.learningjpa.jpademo.entity.Review;
import com.example.learningjpa.jpademo.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Subgraph;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = JpademoApplication.class)
public class CourseSpringDataRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseSpringDataRepository repository;

	@Autowired
	EntityManager em;

	@Test
	public void findById() {
		Optional<Course> course = repository.findById(1001l);
		assertTrue(course.isPresent());

	}

	@Test
	public void findById_courseNotPresent() {
		Optional<Course> course = repository.findById(2001l);
		assertFalse(course.isPresent());
	}

	@Test
	public void playingAround() {
		/*Course course = new Course("Microservices");
		repository.save(course);
		course.setName("Microservices - Updates");
		repository.save(course);*/
		logger.info("Courses -> {}", repository.findAll());
		logger.info("Courses count -> {}", repository.count());

	}

	@Test
	public void sort() {
		Sort sort =  Sort.by(Sort.Direction.DESC,"name");
		logger.info("Sorted Courses -> {}", repository.findAll(sort));
		logger.info("Courses count -> {}", repository.count());

	}

	@Test
	public void paginate() {
		PageRequest pageRequest = PageRequest.of(0,3);
		Page<Course> courses = repository.findAll(pageRequest);
		logger.info("First Page -> {}", courses.getContent());
	}


	@Test
	public void findUsingName() {
		logger.info("FindByName -> {}", repository.findByName("English"));
	}

}