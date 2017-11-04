/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.repo;

import com.mycompany.mavenproject1.Person;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author new
 */
@Repository
public interface PersonRepo extends JpaRepository<Person, Integer>, QueryDslPredicateExecutor<Person> {

    public List<Person> findAll();

    @Modifying
    @Query("delete from Person pers where pers.id= :Id")
    public void deletePerson(@Param("Id") Integer Id);
}
