package com.istarindia.tfylanguage.complexobject;

import java.io.Serializable;

public class OptionPOJO implements Serializable {

	private Integer id;
	private String text;
	
	public OptionPOJO(){
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}	
}
