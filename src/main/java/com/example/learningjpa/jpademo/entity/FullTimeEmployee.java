package com.example.learningjpa.jpademo.entity;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class FullTimeEmployee extends Employee{

    private BigDecimal salary;

    public FullTimeEmployee() {
    }

    public FullTimeEmployee(String name, BigDecimal hourlyWage) {
        super(name);
        this.salary = hourlyWage;
    }
}
