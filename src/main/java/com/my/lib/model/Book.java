package com.my.lib.model;

import javax.validation.constraints.NotEmpty;

public class Book {
    @NotEmpty(message = "Name should not be empty")
    private String title;
    @NotEmpty(message = "Name should not be empty")
    private String author;
    private int year;
    private int id;
}
