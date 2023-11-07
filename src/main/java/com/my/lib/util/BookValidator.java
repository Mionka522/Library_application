package com.my.lib.util;

import com.my.lib.dao.BookDAO;
import com.my.lib.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BookValidator implements Validator {

    private final BookDAO bookDAO;

    @Autowired
    public BookValidator(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    //На каких объектах какого класса будем использовать этот валидатор ( одна сущность для валидатора)
    public boolean supports(Class<?> aClass) {
        return Book.class.equals((aClass));
    }

    @Override
    public void validate(Object target, Errors errors) {
        Book book = (Book) target;
        //Посмотреть, есть ли человек с таким же емайлом
        if(bookDAO.getTitleVal(book.getTitle()).isPresent()) {
            errors.rejectValue("title","","Такая книга уже есть");
        }

    }
}
