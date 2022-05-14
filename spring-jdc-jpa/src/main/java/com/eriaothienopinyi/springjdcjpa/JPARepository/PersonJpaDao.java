package com.eriaothienopinyi.springjdcjpa.JPARepository;

import com.eriaothienopinyi.springjdcjpa.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class PersonJpaDao {
    @PersistenceContext
    EntityManager entityManager;

    //Retrieve record by id
    public Person findById(int id){
        return entityManager.find(Person.class, id);
    }

    public List<Person> findAll(){
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("findAllPersons", Person.class);
        return namedQuery.getResultList();
    }

    //Update a record
    public Person update(Person person){
        return entityManager.merge(person);
    }

    //Insert a record
    public Person save(Person person){
        return entityManager.merge(person);
    }

    //Delete a record
    public void deleteById(int id){
        Person person = findById(id);
        entityManager.remove(person);
    }

}
