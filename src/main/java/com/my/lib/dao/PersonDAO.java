package com.my.lib.dao;

import com.my.lib.model.Book;
import com.my.lib.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }
    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id},
                        new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);

    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person(FIO,year) VALUES(?, ?)", person.getFIO(), person.getYear()
                );
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET FIO=?, year=? WHERE id=?", updatedPerson.getFIO(),
                updatedPerson.getYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }
    public Optional<Person> getPersonByFIO(String FIO) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE FIO=?", new Object[]{FIO},
                        new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny();
    }
    public List <Book> getBookByPErsonID(int id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE person_id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class));
    }
    public Optional<Person> getFIOval(String FIO) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE FIO=?", new Object[]{FIO},
                        new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny();
    }
}
