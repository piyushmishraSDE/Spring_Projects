package com.example.learningjpa.jpademo.repository;

import com.example.learningjpa.jpademo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {

    List<Course> findByName(String name);
    List<Course> countByName(String name);
    List<Course> findByNameOrderByIdDesc(String name);
    void deleteByName(String name);

    @Query("select c from course c where name like '%English%'")
    List<Course> coursesWithCustomQuery();

    @Query(value = "select * from course  where name like '%English%'", nativeQuery = true)
    List<Course> coursesWithCustomQueryNative();

    @Query(name = "query_get_courses")
    List<Course> coursesWithCustomQueryNamed();



}
