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
    public ArrayList<Lesson> lessons;
    public int inCompleteLessons;
    public Boolean isCompleted;

    public GridItem(){}

    public GridItem(int id, String imageUrl, String color, String name, ArrayList<Lesson> lessons, int inCompleteLessons, Boolean isCompleted) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.color = color;
        this.name = name;
        this.lessons = lessons;
        this.inCompleteLessons = inCompleteLessons;
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

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }

    public int getInCompleteLessons() {
        return inCompleteLessons;
    }

    public void setInCompleteLessons(int inCompleteLessons) {
        this.inCompleteLessons = inCompleteLessons;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }
}
