package com.mycompany.mavenproject1.dao;

import com.mycompany.mavenproject1.Employement_history;
import com.mycompany.mavenproject1.Person;
import org.springframework.stereotype.Service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author new
 */
public interface EmploymentHistoryDAO {

    public void addEmploymentHistory(Employement_history employement_history);

    public Integer getEmploymentHistory(String personid);

}
