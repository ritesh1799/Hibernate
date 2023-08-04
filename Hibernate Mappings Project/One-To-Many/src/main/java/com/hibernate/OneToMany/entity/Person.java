package com.hibernate.OneToMany.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {

    @Column(name = "Person_ID")
    @Id
    private int PersonId;

    private String name;

    private String gender;

    // @OneToMany
    //here this @OneToMany annotation creates a new table(3rd table) addressList in our DB which we use for our work
    //Above annotation and 3rd table is created/used if we are managing unidirectional/one way relationship
    //To avoid the use of 3rd table we need to perform bidirectional relationship and it will reduce the creation of new table
    //Bidirectional relationship we can achieve if mapping is happening according to person column of our Address class and that we can achieve by using "mappedBy"
    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    private List<Address> addressList;

    public Person() {
    }


    public Person(int personId, String name, String gender, List<Address> addressList) {
        PersonId = personId;
        this.name = name;
        this.gender = gender;
        this.addressList = addressList;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }


    public int getPersonId() {
        return PersonId;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "PersonId=" + PersonId +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
