package edu.estatuas.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Character {
    @JsonProperty("id")
    private final Integer id;

    public Character(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
}
