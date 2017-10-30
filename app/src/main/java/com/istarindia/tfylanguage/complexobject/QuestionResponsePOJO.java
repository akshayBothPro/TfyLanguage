package com.istarindia.tfylanguage.complexobject;

import java.io.Serializable;
import java.util.List;

public class QuestionResponsePOJO implements Serializable {

	private Integer questionId;
	private List<Integer> options;
	private Integer duration;
	
	public QuestionResponsePOJO(){
		
	}
	
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	
	public List<Integer> getOptions() {
		return options;
	}
	public void setOptions(List<Integer> options) {
		this.options = options;
	}
	
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
}
