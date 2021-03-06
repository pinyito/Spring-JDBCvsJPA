package com.eriaothienopinyi.springjdcjpa.JDBCRepository;

import com.eriaothienopinyi.springjdcjpa.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    //The DAO method that will fetch a list of persons from PERSON table in the database

    //A custom RowMapper
    class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthDate(LocalDateTime.from(rs.getTimestamp("birth_date").toLocalDateTime()));
            return person;
        }
    }
    //Use a custom RowMapper
    public List<Person> findAll(){
        return jdbcTemplate.query(
                        "select * from Person",
                        new PersonRowMapper());
    }

    //Fetch an individual person given an id
    public Person findById(int id){
        return jdbcTemplate.queryForObject("select * from person where id = ?", new Object[]{id},
        new BeanPropertyRowMapper<Person>(Person.class));
    }

    //Delete by id
    public int deleteById(int id){
        return jdbcTemplate.update(
               "delete from person where id = ?", new Object[]{id});
    }

    //Insert a row into the database
    public int save(Person person){
        return jdbcTemplate.update(
                "insert into person(id, name, location, birth_date) "
                + "values(?, ?, ?, ?)",
                new Object[]{
                        person.getId(), person.getName(), person.getLocation(), person.getBirthDate()
                }
        );
    }

    //Update database row
    public int update(Person person){
        return jdbcTemplate.update(
               "update person "
                + "set name = ?, location = ?, birth_date = ? "
                + "where id = ?",
                new Object[]{
                        person.getName(), person.getLocation(), person.getBirthDate(), person.getId()
                }
        );
    }
}
