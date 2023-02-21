package com.example.springboottransaction.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StudentsInfo {
    @Id
    int id;
    String name;
    int roll;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }
}
