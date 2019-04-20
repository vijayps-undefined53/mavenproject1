/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.Serializable;
import java.util.Comparator;
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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Access(AccessType.FIELD)
@Table(name = "PERSON")
public class Person implements Serializable, Comparable<Person>, Comparator<Person> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "personimg")
    private String personimg;

    public String getPersonimg() {
        return personimg;
    }

    public void setPersonimg(String personimg) {
        this.personimg = personimg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return     name;
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

    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Employement_history employement_history;

    public Employement_history getEmployement_history() {
        return employement_history;
    }

    public void setEmployement_history(Employement_history employement_history) {
        this.employement_history = employement_history;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", country=" + country;
    }

    public int compareTo(Person o) {
        if (o.id > id) {
            return 1;
        } else {
            return 0;
        }
    }

    public int compare(Person o1, Person o2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
