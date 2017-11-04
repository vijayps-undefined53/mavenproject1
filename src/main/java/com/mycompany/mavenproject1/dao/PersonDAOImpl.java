/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.dao;

import com.mycompany.mavenproject1.Employement_history;
import com.mycompany.mavenproject1.Person;
import com.mycompany.mavenproject1.PersonSO;
import com.mycompany.mavenproject1.PersonValidator;
import com.mycompany.mavenproject1.QEmployement_history;
import com.mycompany.mavenproject1.QPerson;
import com.mycompany.mavenproject1.repo.PersonRepo;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 *
 * @author new
 */
@Service
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    PersonSO personSO;
    @Autowired
    Employement_history employement_history;
    @Autowired
    PersonRepo personRepo;

    public PersonRepo getPersonRepo() {
        return personRepo;
    }

    public void setPersonRepo(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Employement_history getEmployement_history() {
        return employement_history;
    }

    public void setEmployement_history(Employement_history employement_history) {
        this.employement_history = employement_history;
    }

    public PersonSO getPersonSO() {
        return personSO;
    }

    public void setPersonSO(PersonSO personSO) {
        this.personSO = personSO;
    }

    @PersistenceContext
    EntityManager em;

    //SessionFactory objSessionFactory;
/*
    public SessionFactory getObjSessionFactory() {
        return objSessionFactory;
    }

    public void setObjSessionFactory(SessionFactory objSessionFactory) {
        this.objSessionFactory = objSessionFactory;
    }
     */
    @Override
    public Integer addPerson(Person objperson) {
        // Session objSession = objSessionFactory.openSession();
        //EntityManager em = entityManagerFactory.createEntityManager();
        Integer id;
        //   id = (Integer) objSession.save(objperson);
        //objSession.flush();
        em.persist(objperson);
        em.flush();

        id = objperson.getId();
        return id;
    }

    @Override
    public List<Person> listAllPersons() {
        /*
        Uing pure hibernate querying using session
        Session objSession = objSessionFactory.openSession();
        Query query = objSession.createQuery("from Person");

         */
 /*Using Jpa entity manager querying
       Query query = em.createQuery("select pers from Person pers", Person.class);
        List<Person> listPerson = query.getResultList();
       Using Jpa entity manager querying*/
 /*
       Using JPARepository for querying
        List<Person> listPerson = personRepo.findAll();
         */
        QPerson qperson = QPerson.person;
        List<Person> listPerson = null;
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        listPerson = queryFactory.selectFrom(qperson)
                .orderBy(qperson.name.asc())
                .fetch();
        return listPerson;
    }

    @Override
    public List<Person> selectPerson(int id) {
        //Session objSession = objSessionFactory.openSession();
        //Query query = objSession.createQuery("from Person person where person.id = :id");
        /* queryinng using entitymanager JPA
        Person person = (Person) em.find(Person.class, new Integer(id));
        List<Person> listPerson = new ArrayList<Person>();
        listPerson.add(person);*/
        QPerson qperson = QPerson.person;
        QEmployement_history qEmployement_history = QEmployement_history.employement_history;
        // PathBuilder<Person> personPathBuilder = new PathBuilder<Person>(Person.class, "person");
        //Predicate filter = user.getString("firstName").eq("Bob");
        //List<User> users = query.from(user).where(filter).list(user);

        //  Querydsl queryDsl = new Querydsl(em, personPathBuilder);
        List<Person> listPerson = null;
        //Predicate pred = personPathBuilder.get("id").eq(id);
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        listPerson = queryFactory.selectFrom(qperson)
                .where(qperson.id.eq(id)).fetch();

        //personRepo.findOne(pred);C
        //Querying Using Crieteria API
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = cb.createQuery(Person.class);
        Root<Person> person = criteriaQuery.from(Person.class);
        criteriaQuery.where(person.get("id").in(id));

        TypedQuery<Person> typedQueryPerson = em.createQuery(criteriaQuery);
        listPerson = typedQueryPerson.getResultList();

        return listPerson;
    }

    @Override
    public void deletePerson(int id) {
        /*
        Hibernate Session Delete query
         Session objSession = objSessionFactory.openSession();
        EntityManager em = entityManagerFactory.createEntityManager();
        Person person = (Person) objSession.load(Person.class, new Integer(id));

            objSession.delete(person);
            objSession.flush();

         */
 /*
                     JPA EntityManager  Delete query

       Person person = (Person) em.find(Person.class, new Integer(id));

        if (null != person) {
            em.remove(person);
            em.flush();
        }*/
        personRepo.deletePerson(id);//Spring data jpa @query based delete query
    }

    @Override
    public void editPerson(Person person) {
        //Session objSession = objSessionFactory.openSession();
        //EntityManager em = entityManagerFactory.createEntityManager();

        if (null != person) {
            em.merge(person);
            em.flush();
            // objSession.saveOrUpdate(person);
            // objSession.flush();
        }
    }
}
