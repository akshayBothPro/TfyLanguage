package com.istarindia.tfylanguage.complexobject;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class StudentProfile implements Serializable {

	private Integer id;
	private String authenticationToken;
	private String password;
	private String loginType;
	private Boolean isVerified;
	private String email;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String gender;
	private Long mobile;
	private String location;
	private String profileImage;
	private Integer coins = 0;
	private Integer experiencePoints = 0;
	private Integer batchRank = 0;
	private String underGraduationSpecializationName;
	private String underGraduationDegree;
	private String underGraduationCollege;
	private Integer underGraduationYear;
	private String postGraduationSpecializationName;
	private String postGraduationDegree;
	private String postGraduationCollege;
	private Integer postGraduationYear;
	private List<String> preferredLocations;
	private String resumeURL;

	private String userType;
	private String userCategory;

	public StudentProfile(){

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthenticationToken() {
		return authenticationToken;
	}

	public void setAuthenticationToken(String authenticationToken) {
		this.authenticationToken = authenticationToken;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public Integer getCoins() {
		return coins;
	}

	public void setCoins(Integer coins) {
		this.coins = coins;
	}

	public Integer getExperiencePoints() {
		return experiencePoints;
	}

	public void setExperiencePoints(Integer experiencePoints) {
		this.experiencePoints = experiencePoints;
	}

	public Integer getBatchRank() {
		return batchRank;
	}

	public void setBatchRank(Integer batchRank) {
		this.batchRank = batchRank;
	}

	public String getUnderGraduationSpecializationName() {
		return underGraduationSpecializationName;
	}

	public void setUnderGraduationSpecializationName(String underGraduationSpecializationName) {
		this.underGraduationSpecializationName = underGraduationSpecializationName;
	}

	public String getUnderGraduationDegree() {
		return underGraduationDegree;
	}

	public void setUnderGraduationDegree(String underGraduationDegree) {
		this.underGraduationDegree = underGraduationDegree;
	}

	public String getUnderGraduationCollege() {
		return underGraduationCollege;
	}

	public void setUnderGraduationCollege(String underGraduationCollege) {
		this.underGraduationCollege = underGraduationCollege;
	}

	public String getPostGraduationSpecializationName() {
		return postGraduationSpecializationName;
	}

	public void setPostGraduationSpecializationName(String postGraduationSpecializationName) {
		this.postGraduationSpecializationName = postGraduationSpecializationName;
	}

	public String getPostGraduationDegree() {
		return postGraduationDegree;
	}

	public void setPostGraduationDegree(String postGraduationDegree) {
		this.postGraduationDegree = postGraduationDegree;
	}

	public String getPostGraduationCollege() {
		return postGraduationCollege;
	}

	public void setPostGraduationCollege(String postGraduationCollege) {
		this.postGraduationCollege = postGraduationCollege;
	}

	public String getResumeURL() {
		return resumeURL;
	}

	public void setResumeURL(String resumeURL) {
		this.resumeURL = resumeURL;
	}

	public Integer getUnderGraduationYear() {
		return underGraduationYear;
	}

	public void setUnderGraduationYear(Integer underGraduationYear) {
		this.underGraduationYear = underGraduationYear;
	}

	public Integer getPostGraduationYear() {
		return postGraduationYear;
	}

	public void setPostGraduationYear(Integer postGraduationYear) {
		this.postGraduationYear = postGraduationYear;
	}

	public List<String> getPreferredLocations() {
		return preferredLocations;
	}

	public void setPreferredLocations(List<String> preferredLocations) {
		this.preferredLocations = preferredLocations;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(String userCategory) {
		this.userCategory = userCategory;
	}
}
