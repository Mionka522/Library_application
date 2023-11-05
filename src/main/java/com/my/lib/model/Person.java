package com.my.lib.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Person {
    private int id;
    @NotEmpty(message = "Поле не должно быть пустое")
    @Size(min = 2, max = 30, message = "ФИО не может быть меньше 2 и более 30 символов")
    private String FIO;
    @NotEmpty(message = "Поле не должно быть пустое")
    @Size(min = 3, max = 5, message = "Введите корректный год рождения")
    private String year;



    public Person() {

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
