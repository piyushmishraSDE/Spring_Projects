package com.example.learningjpa.jpademo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "created_date")
    Date created_date;

    @Column(name = "last_updated_date")
    Date last_updated_date;

    @OneToMany(mappedBy = "course" )
    List<Review> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    List<Student> students = new ArrayList<>();

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }


    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getLast_updated_date() {
        return last_updated_date;
    }

    public void setLast_updated_date(Date last_updated_date) {
        this.last_updated_date = last_updated_date;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created_date=" + created_date +
                ", last_updated_date=" + last_updated_date +
                '}';
    }
}
