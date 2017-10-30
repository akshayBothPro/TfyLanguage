package com.istarindia.tfylanguage.complexobject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AssessmentPOJO implements Serializable {

	private Integer id;
	private String type;
	private String name;
	private String category;
	private Integer durationInMinutes;
	private Double points;
	private List<QuestionPOJO> questions = new ArrayList<QuestionPOJO>();
	
	public AssessmentPOJO(){
		
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public Integer getDurationInMinutes() {
		return durationInMinutes;
	}
	public void setDurationInMinutes(Integer durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}
	
	public Double getPoints() {
		return points;
	}
	public void setPoints(Double points) {
		this.points = points;
	}
	
	public List<QuestionPOJO> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuestionPOJO> questions) {
		this.questions = questions;
	}
}
