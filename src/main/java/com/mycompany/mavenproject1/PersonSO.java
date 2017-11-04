/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Service;

/**
 *
 * @author new
 */
@Service
public class PersonSO {

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 30)
    public String name;
    @NotNull
    @NotEmpty
    @Size(min = 2, max = 30)
    public String country;

    public String panNumber;

    public String personImage;

    public Integer empHistId;

    public String id;

    PersonSO() {
    }

    public PersonSO(String id, String name, String country, String panNumber, String personImage) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.panNumber = panNumber;
        this.personImage = personImage;
    }

    public PersonSO(String id, String name, String country, String panNumber, String personImage, Integer empHistId) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.panNumber = panNumber;
        this.personImage = personImage;
        this.empHistId = empHistId;
    }

    public PersonSO(String id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public PersonSO(String id, String name, String country, String panNumber) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.panNumber = panNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPersonImage() {
        return personImage;
    }

    public void setPersonImage(String personImage) {
        this.personImage = personImage;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getEmpHistId() {
        return empHistId;
    }

    public void setEmpHistId(Integer empHistId) {
        this.empHistId = empHistId;
    }

}
