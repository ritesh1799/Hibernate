package com.hibernate.OneToOne.entities;

import javax.persistence.*;

@Entity
@Table(name = "Bike_Detail")
public class Bike {

    @Id
    private int bikeNumber;

    private String bikeName;

    private String engineCapacity;
    @OneToOne                       //it will create the foreign key bike table
    @JoinColumn(name = "Student_ID")
    private Student student;

    public Bike() {
    }

    public Bike(int bikeNumber, String bikeName, String engineCapacity, Student student) {
        this.bikeNumber = bikeNumber;
        this.bikeName = bikeName;
        this.engineCapacity = engineCapacity;
        this.student = student;
    }

    public String getBikeName() {
        return bikeName;
    }

    public int getBikeNumber() {
        return bikeNumber;
    }

    public void setBikeNumber(int bikeNumber) {
        this.bikeNumber = bikeNumber;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
