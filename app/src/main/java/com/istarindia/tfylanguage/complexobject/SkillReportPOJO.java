package com.istarindia.tfylanguage.complexobject;

import java.io.Serializable;
import java.util.List;

public class SkillReportPOJO implements Serializable {

	private Integer id;
	private String name;
	private String description;
	private String itemType;
	private Integer itemId;
	private Double totalPoints = 0.0;
	private Double userPoints = 0.0;
	private Double percentage = 0.0;
	private String message;
	private List<SkillReportPOJO> skills;

	public SkillReportPOJO(){
		
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

	public Double getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(Double totalPoints) {
		this.totalPoints = Math.round(totalPoints*100.0)/100.0;
	}
	
	public Double getUserPoints() {
		return userPoints;
	}
	public void setUserPoints(Double userPoints) {
		this.userPoints = Math.round(userPoints*100.0)/100.0;
	}
	
	public Double getPercentage() {
		return percentage;
	}
	
	public List<SkillReportPOJO> getSkills() {
		return skills;
	}
	public void setSkills(List<SkillReportPOJO> skills) {
		this.skills = skills;
	}
	
	public void calculateTotalPoints() {
		Double totalPoints = 0.0;
		
		for(SkillReportPOJO temp : this.skills){
			totalPoints = totalPoints + temp.getTotalPoints();
		}		
		this.totalPoints = Math.round(totalPoints*100.0)/100.0;
	}
	
	public void calculateUserPoints() {
		Double userPoints = 0.0;
		
		for(SkillReportPOJO temp : this.skills){
			userPoints = userPoints + temp.getUserPoints();
		}		
		this.userPoints = Math.round(userPoints*100.0)/100.0;
	}
	
	public void calculatePercentage() {
		
		if(this.totalPoints > 0){
		this.percentage = (double) (Math.round((((double) this.userPoints)/this.totalPoints)*100.0*100.0)/100.0);
		}else{
			this.percentage = 0.0;
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
