package com.istarindia.tfylanguage.pojo;

import java.io.Serializable;

/**
 * Created by akshay on 10/27/17.
 */

public class Lesson implements Serializable {
    public int id;
    public String description;
    public Boolean completed;

    public Lesson() {

    }

    public Lesson(int id, String description, Boolean completed) {
        this.id = id;
        this.description = description;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
