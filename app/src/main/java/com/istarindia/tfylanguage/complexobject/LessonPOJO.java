package com.istarindia.tfylanguage.complexobject;

import java.io.Serializable;

public class LessonPOJO implements Comparable<LessonPOJO>,Serializable {

	private Integer id;
	private Integer playlistId;
	private String type;
	private String title;
	private String description;
	private String subject;
	private Integer orderId;
	private Integer duration;
	private String status;
	private String lessonUrl;
	private Integer currentSlideId;
	private String imageUrl;

	public LessonPOJO(){
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
		
	public Integer getPlaylistId() {
		return playlistId;
	}
	public void setPlaylistId(Integer playlistId) {
		this.playlistId = playlistId;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int compareTo(LessonPOJO o) {
		return this.orderId -o.orderId;
	}

	public String getLessonUrl() {
		return lessonUrl;
	}

	public void setLessonUrl(String lessonUrl) {
		this.lessonUrl = lessonUrl;
	}

	public Integer getCurrentSlideId() {
		return currentSlideId;
	}

	public void setCurrentSlideId(Integer currentSlideId) {
		this.currentSlideId = currentSlideId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
