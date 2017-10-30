package com.istarindia.tfylanguage.complexobject;

import java.io.Serializable;

/**
 * Created by Feroz on 26-05-2017.
 */

public class CourseItem implements Serializable {

    Integer itemId;
    String itemName;
    Integer orderId;
    String itemType;
    String itemUrl;
    public CourseItem() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Integer getItemId() {
        return itemId;
    }
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }



}
