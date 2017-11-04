/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.dao;

import com.mycompany.mavenproject1.Employement_history;
import com.mycompany.mavenproject1.Person;
import com.mycompany.mavenproject1.repo.EmployementHistoryRepo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.repository.CrudRepository;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.annotations.NamedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author new
 */
@Service
public class EmploymentHistoryDAOImpl implements EmploymentHistoryDAO {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    //SessionFactory objSessionFactory;
    @Autowired
    Employement_history employement_history;
    @Autowired
    Person person;
    @Autowired
    EmployementHistoryRepo employementHistoryRepo;

    public EmployementHistoryRepo getEmployementHistoryRepo() {
        return employementHistoryRepo;
    }

    public void setEmployementHistoryRepo(EmployementHistoryRepo employementHistoryRepo) {
        this.employementHistoryRepo = employementHistoryRepo;
    }

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

    /*  public SessionFactory getObjSessionFactory() {
        return objSessionFactory;
    }

    public void setObjSessionFactory(SessionFactory objSessionFactory) {
        this.objSessionFactory = objSessionFactory;
    }
     */
    @Override
    public void addEmploymentHistory(Employement_history employement_history) {
        /* Session objSession = objSessionFactory.openSession();
        objSession.saveOrUpdate(employement_history);
        objSession.flush();*/

        em.merge(employement_history);
        em.flush();

    }

    @Override
    @Transactional
    public Integer getEmploymentHistory(String personid) {
        Map<String, String> objmap = new HashMap<String, String>();
        //  Session objSession = objSessionFactory.openSession();
        //  Query query = objSession.createQuery("from Employement_history eh where eh.person.id=" + Integer.parseInt(personid));
        //javax.persistence.Query query = em.createQuery("from Employement_history eh where eh.person.id=" + Integer.parseInt(personid));
        //List<Employement_history> employementhistorylist = query.getResultList();
        Employement_history emphist = employementHistoryRepo.findOne(Integer.parseInt(personid));
        Integer emphistid = emphist != null ? emphist.getEmphistid() : 0;
        return emphistid;
        //Hibernate: select employemen0_.emphistid as emphisti1_0_1_, employemen0_.pannumber as pannumbe2_0_1_,
        //employemen0_.personid as personid3_0_1_, person1_.id as id1_1_0_, person1_.country as country2_1_0_, person1_.name as name3_1_0_ from
        //EMPLOYEMENT_HISTORY employemen0_ left outer join PERSON person1_ on employemen0_.personid=person1_.id where employemen0_.personid=?
    }
}
