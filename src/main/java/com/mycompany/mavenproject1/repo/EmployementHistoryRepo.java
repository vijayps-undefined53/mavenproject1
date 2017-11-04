/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.repo;

import com.mycompany.mavenproject1.Employement_history;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployementHistoryRepo extends CrudRepository<Employement_history, Integer>, QueryDslPredicateExecutor<Employement_history> {

    public Employement_history findOne(Integer id);

    /**
     * Finds persons by using the last name as a search criteria.
     *
     * @param personId
     * @return A list of persons which last name is an exact match with the
     * given last name. If no persons is found, this method returns an empty
     * list.
     */
}
