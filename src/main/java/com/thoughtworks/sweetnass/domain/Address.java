package com.thoughtworks.sweetnass.domain;

import org.springframework.util.StringUtils;

public class Address {
    private String city;

    private String state;
    private String areaCode;
    private String address;



    public Address(String city, String state, String areaCode, String address) {
        this.city = city;
        this.state = state;
        this.areaCode = areaCode;
        this.address = address;
    }

    @Override
    public String toString() {
        if(StringUtils.isEmpty(address)) {
            return "no address";
        }
        return "Address: " + address + " " + city + ", " + state + " " + areaCode;
    }
}
