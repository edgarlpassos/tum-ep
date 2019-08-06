package com.edgarlpassos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
class Category {
    public String name;
    public long id;
    public String shortname;
}
