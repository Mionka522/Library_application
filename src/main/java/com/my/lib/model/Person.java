package com.my.lib.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Person {
    private int id;
    @NotEmpty(message = "Поле не должно быть пустое")
    @Size(min = 2, max = 30, message = "ФИО не может быть меньше 2 и более 30 символов")
    private String FIO;

    @Min(value = 0, message = "Age should be greater than 0")
    private int year;



    public Person() {

    }

    public Person(int id, String FIO, int year) {
        this.id = id;
        this.FIO = FIO;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
