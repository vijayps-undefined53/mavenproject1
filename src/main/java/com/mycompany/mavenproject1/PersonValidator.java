/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author new
 */
@Component
public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return PersonSO.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "country is required");
    }

}
