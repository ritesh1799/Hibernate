package com.hibernate.OneToOne.entities;

import javax.persistence.*;

@Entity
@Table(name = "Student_Detail")
public class Student {
    @Id
    private int studentId;

    private String studentName;

    private String address;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)        //Here we are using mapped by so it will not create the foreign key in student table
    private Bike bike;

    public Student() {
    }

    public Student(int studentId, String studentName, String address, Bike bike) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.address = address;
        this.bike = bike;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }
}
