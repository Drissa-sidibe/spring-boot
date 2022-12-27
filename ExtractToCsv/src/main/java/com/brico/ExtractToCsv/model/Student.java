package com.brico.ExtractToCsv.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private long studentId;
    private String name;
    private String address;
    private String city;
    private String pin;
public Student(){

}
    public Student(long studentId, String name, String address, String city, String pin) {
        this.studentId = studentId;
        this.name = name;
        this.address = address;
        this.city = city;
        this.pin = pin;
    }
}
