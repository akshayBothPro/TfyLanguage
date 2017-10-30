package com.istarindia.tfylanguage.complexobject;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class TaskSummaryPOJO implements Serializable {

    private Integer id;
    private String header;
    private String title;
    private String description;
    private String itemType;
    private Integer itemId;
    private Integer duration;
    private String imageURL;
    private String status;
    private Date date;
    private String messageForCompletedTasks;
    private String messageForIncompleteTasks;

    private Date completedDate;
    /*related to assessment task starts here*/
    private Integer numberOfQuestions;
    private Integer itemPoints;
    private Integer itemCoins;
    /*related to assessment task ends here*/

    /*related to classroom task starts here*/
    private Double lattitude;
    private Double longitude;
    private Integer durationHours;
    private Integer durationMinutes;
    private String groupName;
    private Integer classRoomId;
    private String classRoomName;
    private String time;
    private String event_address;
    HashMap<String, String> taskContent ;

    /*related to classroom task ends here*/
    public TaskSummaryPOJO() {

    }


    public Double getLattitude() {
        return lattitude;
    }

    public void setLattitude(Double lattitude) {
        this.lattitude = lattitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(Integer durationHours) {
        this.durationHours = durationHours;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(Integer classRoomId) {
        this.classRoomId = classRoomId;
    }

    public String getClassRoomName() {
        return classRoomName;
    }

    public void setClassRoomName(String classRoomName) {
        this.classRoomName = classRoomName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public Integer getNumberOfQuestions() {
        return numberOfQuestions;
    }


    public void setNumberOfQuestions(Integer numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public Integer getItemPoints() {
        return itemPoints;
    }


    public void setItemPoints(Integer itemPoints) {
        this.itemPoints = itemPoints;
    }

    public Integer getItemCoins() {
        return itemCoins;
    }


    public void setItemCoins(Integer itemCoins) {
        this.itemCoins = itemCoins;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }


    public void setHeader(String header) {
        this.header = header;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
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

    public Integer getDuration() {
        return duration;
    }


    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getImageURL() {
        return imageURL;
    }


    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessageForCompletedTasks() {
        return messageForCompletedTasks;
    }

    public void setMessageForCompletedTasks(String messageForCompletedTasks) {
        this.messageForCompletedTasks = messageForCompletedTasks;
    }

    public String getMessageForIncompleteTasks() {
        return messageForIncompleteTasks;
    }

    public void setMessageForIncompleteTasks(String messageForIncompleteTasks) {
        this.messageForIncompleteTasks = messageForIncompleteTasks;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    public String getEvent_address() {
        return event_address;
    }

    public void setEvent_address(String event_address) {
        this.event_address = event_address;
    }

    public HashMap<String, String> getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(HashMap<String, String> taskContent) {
        this.taskContent = taskContent;
    }
}


