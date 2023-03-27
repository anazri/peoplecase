package com.klarna.people.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class Person {

    @JsonIgnore
    private String id;
    private String name;
    private String ssn;
    private String spouseName;
    private List<Child> children;
}
