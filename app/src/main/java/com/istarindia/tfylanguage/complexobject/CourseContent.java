package com.istarindia.tfylanguage.complexobject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Feroz on 26-05-2017.
 */

public class CourseContent implements Serializable {

    Integer currentItemOrderId;
    Integer nextItemOrderId;
    Integer previousItemOrderId;
    Long currentItemSlideId;

    ArrayList<CourseItem> items;
    String contentUrl;
    Integer courseId;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public CourseContent() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Integer getCurrentItemOrderId() {
        return currentItemOrderId;
    }


    public void setCurrentItemOrderId(Integer currentItemOrderId) {
        this.currentItemOrderId = currentItemOrderId;
    }

    public Integer getNextItemOrderId() {
        return nextItemOrderId;
    }


    public void setNextItemOrderId(Integer nextItemOrderId) {
        this.nextItemOrderId = nextItemOrderId;
    }

    public Integer getPreviousItemOrderId() {
        return previousItemOrderId;
    }


    public void setPreviousItemOrderId(Integer previousItemOrderId) {
        this.previousItemOrderId = previousItemOrderId;
    }


    public ArrayList<CourseItem> getItems() {
        return items;
    }
    public void setItems(ArrayList<CourseItem> items) {
        this.items = items;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public Long getCurrentItemSlideId() {
        return currentItemSlideId;
    }

    public void setCurrentItemSlideId(Long currentItemSlideId) {
        this.currentItemSlideId = currentItemSlideId;
    }
}
