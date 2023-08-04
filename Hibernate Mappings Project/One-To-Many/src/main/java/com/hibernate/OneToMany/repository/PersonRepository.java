package com.hibernate.OneToMany.repository;

import com.hibernate.OneToMany.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Integer> {
}
