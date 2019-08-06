package com.edgarlpassos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Venue {
    public String country;
    public String city;
    public String address_1;
    public String address_2;
    public String address_3;
    public String name;
    public float lon;
    public String zip;
    public String state;
    public float lat;
    public String phone;
}

