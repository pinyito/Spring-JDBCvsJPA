package com.eriaothienopinyi.springjdcjpa;

import com.eriaothienopinyi.springjdcjpa.JPARepository.PersonJpaDao;
import com.eriaothienopinyi.springjdcjpa.Model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("\nRetrieving All Persons: {}", dao.findAll());
		logger.info("\nRetrieving Person With Id 10001: {}", dao.findById(10001));
		dao.deleteById(10002);
		logger.info("\nInserting Person: \nInserted Object: {}", dao.save(new Person(10004, "John", "Somalia", LocalDateTime.of(1986, 10, 9, 12, 30))));
		logger.info("\nUpdating 10003: \nRows updated: {}", dao.update(new Person(10003, "Martha", "Kampala", LocalDateTime.of(1999, 5, 15, 9, 50))));
		//Retrieving all Persons after changes were made
		logger.info("\nRetrieving All Persons: {}", dao.findAll());
	}
}
