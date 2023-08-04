package com.hibernate.OneToOne.repository;

import com.hibernate.OneToOne.entities.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeRepository extends JpaRepository<Bike,Integer> {

}
