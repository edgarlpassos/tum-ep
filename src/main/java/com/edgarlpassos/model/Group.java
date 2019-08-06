package com.edgarlpassos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Group {
    public String join_mode;
    public String country;
    public String name;
    public float group_lon;
    public float group_lat;
    public long id;
    public String urlname;
    public String city;
    public String state;
    public Category category;
    public GroupPhoto group_photo;
}
