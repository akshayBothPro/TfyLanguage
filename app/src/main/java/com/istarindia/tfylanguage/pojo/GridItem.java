package com.istarindia.tfylanguage.pojo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by akshay on 10/27/17.
 */

public class GridItem implements Serializable {

    public int id;
    public String imageUrl;
    public String color;
    public String name;
    public ArrayList<AssessmentPojo> lessons;
    public Boolean isCompleted;


    public GridItem(int id, String imageUrl, String color, String name, ArrayList<AssessmentPojo> lessons, Boolean isCompleted) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.color = color;
        this.name = name;
        this.lessons = lessons;
        this.isCompleted = isCompleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<AssessmentPojo> getLessons() {
        return lessons;
    }

    public void setLessons(ArrayList<AssessmentPojo> lessons) {
        this.lessons = lessons;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }
}
