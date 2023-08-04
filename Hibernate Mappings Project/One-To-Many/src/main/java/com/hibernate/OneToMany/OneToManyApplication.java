package com.hibernate.OneToMany;

import com.hibernate.OneToMany.entity.Address;
import com.hibernate.OneToMany.entity.Person;
import com.hibernate.OneToMany.repository.AddressRepository;
import com.hibernate.OneToMany.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
public class OneToManyApplication implements CommandLineRunner {

	// one person can have many addresses  one-to-many
	// many addresses have one person   many-to-one

	@Autowired
	PersonRepository personRepository;

	@Autowired
	AddressRepository addressRepository;
	public static void main(String[] args) {
		SpringApplication.run(OneToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//create person object
		Person person = new Person();
		 person.setPersonId(7);
		 person.setName("Sunny");
		 person.setGender("Male");
//Create List of address
		List<Address> addressList = new ArrayList<>();

		//create 1st address for person
		 Address address1 = new Address();
		 address1.setAddressId(1);
		 address1.setCity("Ranchi");
		 address1.setPinCode(834005);
		 address1.setCountry("India");
		 //pass your person to address1
		 address1.setPerson(person);

		 //create 2nd address for person
		 Address address2 = new Address();
		 address2.setAddressId(2);
		 address2.setCity("Bengaluru");
		 address2.setPinCode(560100);
		 address2.setCountry("India");
		 //set or provide the person to address2
		 address2.setPerson(person);

		 //create 3rd address for person
		 Address address3 = new Address();
		 address3.setAddressId(3);
		 address3.setCity("Chicago");
		 address3.setPinCode(60007);
		 address3.setCountry("America");
		 //set the person for address3
		 address3.setPerson(person);

		 addressList.add(address1);
		 addressList.add(address2);
		 addressList.add(address3);

		 person.setAddressList(addressList);

		 //save our person object. Again here we are using cascade so we don't need to manually save address object.
		 Person save = personRepository.save(person);

		log.info("Get details Person id:{}, AddressList;{}",save.getPersonId(), save.getAddressList().toString());


	}
}
