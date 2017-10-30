package com.istarindia.tfylanguage.complexobject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModulePOJO implements Comparable<ModulePOJO>,Serializable {

	private Integer id;
	private String name;
	private String description;
	private String status;
	private String imageURL;
	private Integer orderId;
	private List<ConcreteItemPOJO> lessons = new ArrayList<ConcreteItemPOJO>();
	private List<String> skillObjectives = new ArrayList<String>();
	
	public ModulePOJO(){
		
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
	
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	public List<ConcreteItemPOJO> getLessons() {
		return lessons;
	}

	public void setLessons(List<ConcreteItemPOJO> lessons) {
		this.lessons = lessons;
	}

	public List<String> getSkillObjectives() {
		return skillObjectives;
	}
	public void setSkillObjectives(List<String> skillObjectives) {
		this.skillObjectives = skillObjectives;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public ModulePOJO sortLessonsAndAssignStatus(){		
		ModulePOJO modulePOJO = this;		
		Collections.sort(modulePOJO.getLessons());
		
		String moduleStatus = "COMPLETED";
		
		for(ConcreteItemPOJO cmsession: modulePOJO.getLessons()){
			if((cmsession.getStatus().equals("INCOMPLETE"))){
				moduleStatus = "INCOMPLETE";
			}
		}
		modulePOJO.setStatus(moduleStatus);	
	return modulePOJO;
	}
	
	@Override
	public int compareTo(ModulePOJO o) {
		return this.orderId -o.orderId;
	}
}
