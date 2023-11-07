package com.my.lib.util;

import com.my.lib.dao.PersonDAO;
import com.my.lib.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    //На каких объектах какого класса будем использовать этот валидатор ( одна сущность для валидатора)
    public boolean supports(Class<?> aClass) {
        return Person.class.equals((aClass));
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        //Посмотреть, есть ли человек с таким же емайлом
        if(personDAO.getFIOval(person.getFIO()).isPresent()) {
            errors.rejectValue("FIO","","Такой человек уже есть");
        }
    }
}
