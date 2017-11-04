/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.service;

import com.mycompany.mavenproject1.Employement_history;
import com.mycompany.mavenproject1.Person;
import com.mycompany.mavenproject1.PersonSO;
import com.mycompany.mavenproject1.dao.EmploymentHistoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author new
 */
@Service
public class EmploymentHistoryServiceImpl implements EmploymentHistoryService {

    @Autowired
    PersonSO personSO;

    public PersonSO getPersonSO() {
        return personSO;
    }

    public void setPersonSO(PersonSO personSO) {
        this.personSO = personSO;
    }

    @Autowired
    Employement_history employement_history;
    @Autowired
    Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Employement_history getEmployement_history() {
        return employement_history;
    }

    public void setEmployement_history(Employement_history employement_history) {
        this.employement_history = employement_history;
    }
    @Autowired
    EmploymentHistoryDAO employmentHistoryDAO;

    public EmploymentHistoryDAO getEmploymentHistoryDAO() {
        return employmentHistoryDAO;
    }

    public void setEmploymentHistoryDAO(EmploymentHistoryDAO employmentHistoryDAO) {
        this.employmentHistoryDAO = employmentHistoryDAO;
    }

    @Override
    @Transactional

    public void addEmploymentHistory(PersonSO personSO) {
        this.person.setId(Integer.parseInt(personSO.getId().trim()));
        this.person.setName(personSO.getName());
        this.person.setCountry(personSO.getCountry());
        this.employement_history.setPannumber(personSO.getPanNumber());
        this.employement_history.setPerson(this.person);
        employmentHistoryDAO.addEmploymentHistory(this.employement_history);
    }

    @Override
    @Transactional
    public Integer getEmploymentHistory(String personid) {
        return employmentHistoryDAO.getEmploymentHistory(personid);
    }

}
