package com.thoughtworks.sweetnass.controllers;

import com.thoughtworks.sweetnass.config.AppConfig;
import com.thoughtworks.sweetnass.config.ApplicationContext;
import com.thoughtworks.sweetnass.domain.Address;
import com.thoughtworks.sweetnass.domain.Person;
import com.thoughtworks.sweetnass.repository.PeopleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class, ApplicationContext.class})
public class PeopleControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private PeopleRepository peopleRepository;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void shouldReturnAddress() throws Exception {

        Address address = new Address("Chicago", "IL", "60601", "200 E Randolph st.");
        Person person = new Person("Brandon", address);

        peopleRepository.savePerson(person);

        mockMvc.perform(get("/person/brandon/address"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("address", address.toString()));
    }
}