package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tag {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    public Tag() {
        this.id = 0;
        this.name = "string";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

