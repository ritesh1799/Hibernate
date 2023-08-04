package com.hibernate.OneToMany.entity;

import javax.persistence.*;

@Entity
@Table(name = "Address_Details")
public class Address {

    @Id
    private int addressId;

    private String city;

    private int pinCode;

    private String country;

    @ManyToOne              //Many Address can have only one person
    @JoinColumn(name = "Person_ID")
    private Person person;

    public Address() {
    }

    public Address(int addressId, String city, int pinCode, String country, Person person) {
        this.addressId = addressId;
        this.city = city;
        this.pinCode = pinCode;
        this.country = country;
        this.person = person;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", city='" + city + '\'' +
                ", pinCode=" + pinCode +
                ", country='" + country + '\'' +
                ", person=" + person +
                '}';
    }
}
