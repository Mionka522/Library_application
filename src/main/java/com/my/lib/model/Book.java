package com.my.lib.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Book {
    @NotEmpty(message = "Name should not be empty")
    private String title;
    @NotEmpty(message = "Name should not be empty")
    @Pattern(regexp = "[A-Z]\\w+\\s[A-Z]\\w+\\.[A-Z]\\w+\\.", message = "Должен быть формат Фамилия И.О.")
    private String author;
    @NotEmpty(message = "Поле не должно быть пустое")
    @Size(min = 3, max = 5, message = "Введите корректный год рождения")
    private String year;
    private int id;
    public Book(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
