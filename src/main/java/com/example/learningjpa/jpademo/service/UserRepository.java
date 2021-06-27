package com.example.learningjpa.jpademo.service;

import com.example.learningjpa.jpademo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
