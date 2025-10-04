package edu.estatuas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("status")
    private String status;
    @JsonProperty("image")
    private String image;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("origin")
    private JsonNode origin;

    public Character() {}

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getImage() {
        return image;
    }

    public String getGender() {
        return gender;
    }

    public JsonNode getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append(": {\n")
            .append("ID: ").append(getId()).append("\n")
            .append("Status: ").append(getStatus()).append("\n")
            .append("Image: ").append(getImage()).append("\n")
            .append("Gender: ").append(getGender()).append("\n}");
        
        return sb.toString();
    }
}
