package com.hibernate.OneToOne.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private int userID;

    private int user_age;

    private int user_city;

    private int user_name;
}
