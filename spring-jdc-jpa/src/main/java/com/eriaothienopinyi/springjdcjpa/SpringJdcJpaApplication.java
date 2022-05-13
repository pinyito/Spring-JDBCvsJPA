package com.eriaothienopinyi.springjdcjpa;

import com.eriaothienopinyi.springjdcjpa.JDBCRepository.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		logger.info("All persons -> {}",dao.findAll());
		logger.info("Person with id 10001 -> {}", dao.findById(10001));
	}
}
