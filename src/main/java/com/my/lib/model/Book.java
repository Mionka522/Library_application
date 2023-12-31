package com.my.lib.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Book {
    @NotEmpty(message = "Name should not be empty")
    private String title;
    @NotEmpty(message = "Name should not be empty")
    private String author;

    @Min(value = 0, message = "Age should be greater than 0")
    private int year;
    private int id;
    public Book(){

    }

    public Book(String title, String author, int year, int id) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.id = id;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
