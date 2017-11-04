/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.service;

import com.mycompany.mavenproject1.Person;
import com.mycompany.mavenproject1.PersonSO;
import java.util.List;

/**
 *
 * @author new
 */
public interface PersonService {

    public void addPerson(PersonSO objp);

    public Integer addPersonAndImage(PersonSO objp);

    public List<PersonSO> listAllPersons();

    public PersonSO selectPerson(int id);

    public void deletePerson(int id);

    public void editPerson(PersonSO personSO);

}
