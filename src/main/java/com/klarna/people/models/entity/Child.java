package com.klarna.people.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.klarna.people.models.dto.ChildDto;
import com.klarna.people.models.dto.PersonDto;
import lombok.Data;

import java.util.UUID;

@Data
public class Child {

    @JsonIgnore
    private String id;
    private String name;
    @JsonIgnore
    private int age;
    private String parentSsn;

    public Child(ChildDto childDto, String parentSsn) {
        this.id = UUID.randomUUID().toString();
        this.name = childDto.getName();
        this.age = childDto.getAge();
        this.parentSsn = parentSsn;
    }
}
