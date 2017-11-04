/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.service;

import com.mycompany.mavenproject1.Person;
import com.mycompany.mavenproject1.PersonSO;
import com.mycompany.mavenproject1.dao.PersonDAO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author new
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonDAO personDAO;
    @Autowired
    PersonSO personSO;
    @Autowired
    Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public PersonSO getPersonSO() {
        return personSO;
    }

    public void setPersonSO(PersonSO personSO) {
        this.personSO = personSO;
    }

    public PersonDAO getPersonDAO() {
        return personDAO;
    }

    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    @Transactional
    public void addPerson(PersonSO personSO) {
        this.person.setName(personSO.getName());
        this.person.setCountry(personSO.getCountry());

        personDAO.addPerson(this.person);
    }

    @Override
    @Transactional
    public Integer addPersonAndImage(PersonSO personSO) {
        this.person.setName(personSO.getName());
        this.person.setCountry(personSO.getCountry());
        this.person.setPersonimg(personSO.getPersonImage());
        return personDAO.addPerson(this.person);
    }

    @Override
    @Transactional
    public List<PersonSO> listAllPersons() {
        List<Person> persons = personDAO.listAllPersons();
        List<PersonSO> listpersonSO = new ArrayList<PersonSO>();
        PersonSO personSO1 = null;
        String panNumber = null;
        Integer empHistId = null;
        for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext();) {
            Person nextperson = iterator.next();
            if (nextperson.getEmployement_history() != null) {
                panNumber = nextperson.getEmployement_history().getPannumber();
                empHistId = nextperson.getEmployement_history().getEmphistid();
            }

            personSO1 = new PersonSO(nextperson.getId() + "", nextperson.getName(), nextperson.getCountry(), panNumber, nextperson.getPersonimg(), empHistId);
            listpersonSO.add(personSO1);
        }
        return listpersonSO;
    }

    @Override
    @Transactional

    public PersonSO selectPerson(int id) {
        List<Person> listPerson = personDAO.selectPerson(id);
        if (!listPerson.isEmpty()) {
            this.person = listPerson.get(0);
            this.personSO.setId(this.person.getId() + "");
            this.personSO.setName(this.person.getName());
            this.personSO.setCountry(this.person.getCountry());
            return this.personSO;
        } else {
            return null;
        }
    }

    @Override
    @Transactional

    public void deletePerson(int id) {
        personDAO.deletePerson(id);
    }

    @Override
    @Transactional

    public void editPerson(PersonSO personSO) {
        this.person.setId(Integer.parseInt(personSO.getId()));
        this.person.setName(personSO.getName());
        this.person.setCountry(personSO.getCountry());
        personDAO.editPerson(this.person);
    }
}
