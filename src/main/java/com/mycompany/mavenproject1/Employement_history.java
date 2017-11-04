/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author new
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "EMPLOYEMENT_HISTORY")
public class Employement_history implements Serializable {

    @Id
    @Column(name = "emphistid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer emphistid;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "personid")
    private Person person;

    @Column(name = "pannumber")
    private String pannumber;

    @OneToMany(mappedBy = "employementHistory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EmployeeHistoryDetails> employeeHistoryDetails;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getEmphistid() {
        return emphistid;
    }

    public void setEmphistid(Integer emphistid) {
        this.emphistid = emphistid;
    }

    public String getPannumber() {
        return pannumber;
    }

    public void setPannumber(String pannumber) {
        this.pannumber = pannumber;
    }

    public List<EmployeeHistoryDetails> getEmployeeHistoryDetails() {
        return employeeHistoryDetails;
    }

    public void setEmployeeHistoryDetails(List<EmployeeHistoryDetails> employeeHistoryDetails) {
        this.employeeHistoryDetails = employeeHistoryDetails;
    }

}
