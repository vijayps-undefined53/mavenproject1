/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.dao;

import com.mycompany.mavenproject1.Person;
import java.util.List;

/**
 *
 * @author new
 */
public interface PersonDAO {

    public Integer addPerson(Person objp);

    public List<Person> listAllPersons();

    public List<Person> selectPerson(int id);

    public void deletePerson(int id);

    public void editPerson(Person person);

}
