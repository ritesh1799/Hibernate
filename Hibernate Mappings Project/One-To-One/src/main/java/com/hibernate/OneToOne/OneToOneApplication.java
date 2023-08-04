package com.hibernate.OneToOne;

import com.hibernate.OneToOne.entities.Bike;
import com.hibernate.OneToOne.entities.Student;
import com.hibernate.OneToOne.repository.BikeRepository;
import com.hibernate.OneToOne.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class OneToOneApplication implements CommandLineRunner {

	@Autowired
	BikeRepository bikeRepository;

	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Student student = new Student();
		student.setStudentId(1);
		student.setStudentName("Sunny");
		student.setAddress("EC Phase2");

		Bike bike = new Bike();
		bike.setBikeName("Royal Enfield");
		bike.setEngineCapacity("220 CC");
		bike.setBikeNumber(1123);

		//set student
		bike.setStudent(student);

		//below is optional but it's good practice to understand
		student.setBike(bike);

		//if we are using cascade.ALL then we don't need to save bike details manually ( bikeRepository.save(bike) )because it cascade automatically add the bike details in table
		Student save = studentRepository.save(student);

		log.info("save :{}",save.getStudentId());

	}
}
