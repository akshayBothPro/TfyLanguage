package com.istarindia.tfylanguage.complexobject;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;

public class NotificationPOJO implements Serializable {

    private Integer id;
    private String message;
    private String status;
    private String imageURL;
    private Timestamp time;
    private String itemType;
    private Integer itemId;
    private HashMap<String, Object> item = new HashMap<String, Object>();

    public NotificationPOJO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public HashMap<String, Object> getItem() {
        return item;
    }

    public void setItem(HashMap<String, Object> item) {
        this.item = item;
    }
}
