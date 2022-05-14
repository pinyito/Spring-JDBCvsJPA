package com.eriaothienopinyi.springjdcjpa;

import com.eriaothienopinyi.springjdcjpa.JDBCRepository.PersonJdbcDao;
import com.eriaothienopinyi.springjdcjpa.Model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class  SpringJdcJpaApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdcJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("\nRetrieving All Persons: {}", dao.findAll());
		logger.info("\nRetrieving Person With Id 10001: {}", dao.findById(10001));
		logger.info("\nDeleting 10002: \nRows deleted: {}", dao.deleteById(10002));
		logger.info("\nInserting 10004: \nRows inserted: {}", dao.save(new Person(10004, "John", "Somalia", LocalDateTime.of(1986, 10, 9, 12, 30))));
		logger.info("\nUpdating 10003: \nRows updated: {}", dao.update(new Person(10003, "Martha", "Kampala", LocalDateTime.of(1999, 5, 15, 9, 50))));
		//Retrieving all Persons after changes were made
		logger.info("\nRetrieving All Persons: {}", dao.findAll());
	}
}
