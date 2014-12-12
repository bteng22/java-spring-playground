package com.thoughtworks.sweetnass.domain;

public class Person {
    private Address address;
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
