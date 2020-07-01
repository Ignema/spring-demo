package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Person {

    private final UUID uid;
    @NotBlank
    private final String name;

    public Person(@JsonProperty("id") UUID uid, @JsonProperty("name") String name) {
        this.uid = uid;
        this.name = name;
    }


    public UUID getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }
}
