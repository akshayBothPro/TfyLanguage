package com.istarindia.tfylanguage.complexobject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AssessmentResponsePOJO implements Serializable {

	private Integer id;
	private List<QuestionResponsePOJO> response = new ArrayList<QuestionResponsePOJO>();
		
	public AssessmentResponsePOJO(){
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<QuestionResponsePOJO> getResponse() {
		return response;
	}
	public void setResponse(List<QuestionResponsePOJO> response) {
		this.response = response;
	}
}
