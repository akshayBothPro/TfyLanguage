package com.istarindia.tfylanguage.complexobject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AssessmentReportPOJO implements Serializable {

	private Integer id;
	private String name;
	private Double userScore;
	private Double totalScore;
	private Double accuracy;
	private Double batchAverage;
	private Integer usersAttemptedCount;
	private Integer totalNumberOfUsersInBatch;
	private Integer totalNumberOfQuestions;
	private Integer totalNumberOfCorrectlyAnsweredQuestions;
	private String message;
	private String messageDescription;
	private List<SkillReportPOJO> skillsReport = new ArrayList<SkillReportPOJO>();
	private AssessmentResponsePOJO assessmentResponse;
	private Boolean retryable;

	public AssessmentReportPOJO(){

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

	public Double getUserScore() {
		return userScore;
	}
	public void setUserScore(Double userScore) {
		this.userScore = Math.round(userScore*100.0)/100.0;
	}

	public Double getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Double totalScore) {
		this.totalScore = Math.round(totalScore*100.0)/100.0;
	}

	public Double getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(Double accuracy) {
		this.accuracy = accuracy;
	}

	public Double getBatchAverage() {
		return batchAverage;
	}
	public void setBatchAverage(Double batchAverage) {
		this.batchAverage = Math.round(batchAverage*100.0*100.0)/100.0;
	}

	public Integer getUsersAttemptedCount() {
		return usersAttemptedCount;
	}
	public void setUsersAttemptedCount(Integer usersAttemptedCount) {
		this.usersAttemptedCount = usersAttemptedCount;
	}

	public Integer getTotalNumberOfUsersInBatch() {
		return totalNumberOfUsersInBatch;
	}
	public void setTotalNumberOfUsersInBatch(Integer totalNumberOfUsersInBatch) {
		this.totalNumberOfUsersInBatch = totalNumberOfUsersInBatch;
	}

	public List<SkillReportPOJO> getSkillsReport() {
		return skillsReport;
	}
	public void setSkillsReport(List<SkillReportPOJO> skillsReport) {
		this.skillsReport = skillsReport;
	}

	public Integer getTotalNumberOfQuestions() {
		return totalNumberOfQuestions;
	}
	public void setTotalNumberOfQuestions(Integer totalNumberOfQuestions) {
		this.totalNumberOfQuestions = totalNumberOfQuestions;
	}

	public Integer getTotalNumberOfCorrectlyAnsweredQuestions() {
		return totalNumberOfCorrectlyAnsweredQuestions;
	}
	public void setTotalNumberOfCorrectlyAnsweredQuestions(Integer totalNumberOfCorrectlyAnsweredQuestions) {
		this.totalNumberOfCorrectlyAnsweredQuestions = totalNumberOfCorrectlyAnsweredQuestions;
	}		
	
	public void calculateUserScore() {
		double userScore = 0.0;
		for(SkillReportPOJO skillReportPOJO : this.skillsReport){
			userScore = userScore + skillReportPOJO.getUserPoints();
		}
		this.userScore = Math.round(userScore*100.0)/100.0;
	}
	
	public void calculateTotalScore() {
		double totalScore = 0.0;
		for(SkillReportPOJO skillReportPOJO : this.skillsReport){
			totalScore = totalScore + skillReportPOJO.getTotalPoints();
		}
		this.totalScore = Math.round(totalScore*100.0)/100.0;
	}
	
	public void calculateAccuracy() {
		this.accuracy = (double) (Math.round((((double) this.totalNumberOfCorrectlyAnsweredQuestions)/this.totalNumberOfQuestions)*100.0*100.0)/100.0);
		}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageDescription() {
		return messageDescription;
	}

	public void setMessageDescription(String messageDescription) {
		this.messageDescription = messageDescription;
	}

	public AssessmentResponsePOJO getAssessmentResponse() {
		return assessmentResponse;
	}

	public void setAssessmentResponse(AssessmentResponsePOJO assessmentResponse) {
		this.assessmentResponse = assessmentResponse;
	}

	public Boolean getRetryable() {
		return retryable;
	}

	public void setRetryable(Boolean retryable) {
		this.retryable = retryable;
	}
}
