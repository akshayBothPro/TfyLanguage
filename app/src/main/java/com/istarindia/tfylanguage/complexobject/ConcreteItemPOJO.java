package com.istarindia.tfylanguage.complexobject;

import java.io.Serializable;

public class ConcreteItemPOJO implements Comparable<ConcreteItemPOJO>,Serializable {

    private Integer id;
    private String type;
    private LessonPOJO lesson;
    private AssessmentPOJO assessment;
    private String status;
    private Integer orderId = 0;
    private Integer taskId;
    private Integer progress;


    //add date field
    public ConcreteItemPOJO(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LessonPOJO getLesson() {
        return lesson;
    }

    public void setLesson(LessonPOJO lesson) {
        this.lesson = lesson;
    }

    public AssessmentPOJO getAssessment() {
        return assessment;
    }

    public void setAssessment(AssessmentPOJO assessment) {
        this.assessment = assessment;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int compareTo(ConcreteItemPOJO o) {
        return this.orderId -o.orderId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }
}