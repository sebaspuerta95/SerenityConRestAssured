package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JsonPropertyOrder({"id", "category", "name", "photoUrls", "tags", "status"})
public class Pet {

    @JsonProperty("id")
    private int id;

    @JsonProperty("category")
    private Category category;

    @JsonProperty("name")
    private String name;

    @JsonProperty("photoUrls")
    private List<String> photoUrls;

    @JsonProperty("tags")
    private List<Tag> tags;

    @JsonProperty("status")
    private String status;

    public Pet(int id, String name, String status) {
        this.id = id;

        this.category = new Category();

        this.name = name;
        this.photoUrls = Collections.singletonList("string");

        Tag tag = new Tag();
        List<Tag> tags = new ArrayList<>();
        tags.add(tag);
        this.tags = tags;

        this.status = status;
    }

    public Pet(int id) {
        this.id = id;

        this.category = new Category();

        this.name = "doggie";
        this.photoUrls = Collections.singletonList("string");

        Tag tag = new Tag();
        List<Tag> tags = new ArrayList<>();
        tags.add(tag);
        this.tags = tags;

        this.status = "available";
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

