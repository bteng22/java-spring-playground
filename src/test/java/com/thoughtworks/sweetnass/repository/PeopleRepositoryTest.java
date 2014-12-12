package com.thoughtworks.sweetnass.repository;

import com.thoughtworks.sweetnass.domain.Person;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PeopleRepositoryTest {

    @Test
    public void testGetPerson() throws Exception {
        PeopleRepository peopleRepository = new PeopleRepository();
        peopleRepository.savePerson(new Person("Jo"));
        peopleRepository.savePerson(new Person("Jen"));
        Person jake = new Person("Jake");
        peopleRepository.savePerson(jake);

        assertThat(peopleRepository.getPerson("Jake"), is(jake));
    }

    @Test
    public void findPersonRegardlessOfLetterCase() throws Exception {
        PeopleRepository peopleRepository = new PeopleRepository();
        Person jake = new Person("JoHaNeS");
        peopleRepository.savePerson(jake);

        assertThat(peopleRepository.getPerson("johanes"), is(jake));
    }
}