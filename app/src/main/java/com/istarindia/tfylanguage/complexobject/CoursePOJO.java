package com.istarindia.tfylanguage.complexobject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoursePOJO implements Serializable {

	private Integer id;
	private String name;
	private String description;
	private String category;
	private String imageURL;
	private String status;
	private Integer rank;
	private Double userPoints = 0.0;
	private Double totalPoints = 0.0;
	private Double progress = 0.0;
	private String message;
	private List<ModulePOJO> modules = new ArrayList<ModulePOJO>();
	private List<SkillReportPOJO> skillObjectives = new ArrayList<SkillReportPOJO>();
	
	public CoursePOJO(){
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	
	public List<ModulePOJO> getModules() {
		return modules;
	}
	public void setModules(List<ModulePOJO> modules) {
		this.modules = modules;
	}
	
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	
	public Double getUserPoints() {
		return userPoints;
	}
	public void setUserPoints(Double userPoints) {
		this.userPoints = userPoints;
	}
	
	public Double getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(Double totalPoints) {
		this.totalPoints = Math.round(totalPoints*100.0)/100.0;
	}
	
	public Double getProgress() {
		return progress;
	}
	public void setProgress(Double progress) {
		this.progress = Math.round(progress*100.0)/100.0;
	}
		
	public List<SkillReportPOJO> getSkillObjectives() {
		return skillObjectives;
	}
	public void setSkillObjectives(List<SkillReportPOJO> skillObjectives) {
		this.skillObjectives = skillObjectives;
	}
	
	public CoursePOJO sortModulesAndAssignStatus(){		
		CoursePOJO coursePOJO = this;		
		Collections.sort(coursePOJO.getModules());
		
		String courseStatus = "COMPLETED";
		
		for(ModulePOJO module: coursePOJO.getModules()){
			if(module.getStatus().equals("INCOMPLETE")){
				courseStatus = "INCOMPLETE";
			}
		}
		coursePOJO.setStatus(courseStatus);	
	return coursePOJO;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
