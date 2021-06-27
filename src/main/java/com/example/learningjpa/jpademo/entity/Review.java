package com.example.learningjpa.jpademo.entity;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "desc")
    private String desc;

    @Column(name = "rating")
    private String rating;

    @ManyToOne
    private Course course;

    public Review() {
    }

    public Review(String desc, String rating) {
        this.desc = desc;
        this.rating = rating;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                '}';
    }
}
