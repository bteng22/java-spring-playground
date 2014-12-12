package com.thoughtworks.sweetnass.controllers;

import com.thoughtworks.sweetnass.domain.Person;
import com.thoughtworks.sweetnass.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/person")
public class PeopleController {

    @Autowired
    private PeopleRepository peopleRepository;

    @RequestMapping(value="{name}/address", method = RequestMethod.GET)
    public String getAddress(@PathVariable("name") String name, ModelMap model) {
        Person person = peopleRepository.getPerson(name);

        String output;
        if(person != null) {
            output = person.getAddress().toString();
        } else {
            output = "No Bueno~";
        }

        model.addAttribute("address", output);

        return "thisMapsToJSPFileName";
    }
}
