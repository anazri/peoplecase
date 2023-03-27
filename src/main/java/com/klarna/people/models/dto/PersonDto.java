package com.klarna.people.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class PersonDto {
    private String name;
    private String ssn;
    private String spouseName;
    private List<ChildDto> children;
}
