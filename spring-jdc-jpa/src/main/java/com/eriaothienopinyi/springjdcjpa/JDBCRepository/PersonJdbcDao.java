package com.eriaothienopinyi.springjdcjpa.JDBCRepository;

import com.eriaothienopinyi.springjdcjpa.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    //The DAO method that will fetch a list of persons from PERSON table in the database
    public List<Person> findAll(){
        return jdbcTemplate.query(
                        "select * from Person",
                        new BeanPropertyRowMapper<Person>(Person.class));
    }

    //Fetch an individual person given an id
    public Person findById(int id){
        return jdbcTemplate.queryForObject("select * from person where id = ?", new Object[]{id},
        new BeanPropertyRowMapper<Person>(Person.class));
    }
}