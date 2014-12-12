package com.thoughtworks.sweetnass.repository;

import com.thoughtworks.sweetnass.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class PeopleRepository {

    private List<Person> people;

    public PeopleRepository() {
        people = new ArrayList<Person>();
    }

    public Person getPerson(String name) {
        for (Person person : people) {
            if(person.getName().toLowerCase().equals(name.toLowerCase())){
                return person;
            }
        }
        return null;
    }

    public void savePerson(Person person) {
        people.add(person);
    }
}
