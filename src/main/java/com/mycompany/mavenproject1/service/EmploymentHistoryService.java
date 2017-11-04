/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.service;

import com.mycompany.mavenproject1.PersonSO;
import org.springframework.stereotype.Service;

/**
 *
 * @author new
 */
@Service

public interface EmploymentHistoryService {

    public void addEmploymentHistory(PersonSO objp);

    public Integer getEmploymentHistory(String personid);

}
