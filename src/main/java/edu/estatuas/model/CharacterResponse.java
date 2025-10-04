package edu.estatuas.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CharacterResponse {
    @JsonProperty("info")
    private Info info;
    
    @JsonProperty("results")
    private List<Character> results;

    public Info getInfo() {
        return info;
    }

    public List<Character> getResults() {
        return results;
    }

    public static class Info {
        @JsonProperty("count")
        private int count;
        @JsonProperty("pages")
        private int pages;
        @JsonProperty("next")
        private String next;
        @JsonProperty("prev")
        private String prev;

        public String getNext() {
            return next;
        }
    }

}