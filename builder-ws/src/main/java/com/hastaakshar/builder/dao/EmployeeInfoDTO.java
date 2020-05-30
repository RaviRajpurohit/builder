package com.hastaakshar.builder.dao;

import java.util.Date;

import com.hastaakshar.builder.util.BuilderUtil;
import com.hastaakshar.builder.ws.EmployeeInfo;

public class EmployeeInfoDTO {

	public EmployeeInfoDTO() {
	}

	public EmployeeInfoDTO(EmployeeInfo employeeInfo, String resumeLocation) {
		this.id = BuilderUtil.genrateUUID();
		this.name = employeeInfo.getName();
		this.emailId = employeeInfo.getEmailId();
		this.mobileNumber = employeeInfo.getMobileNumber();
		this.fatherName = employeeInfo.getFatherName();
		this.motherName = employeeInfo.getMotherName();
		this.age = employeeInfo.getAge();
		this.dob = employeeInfo.getDob();
		this.currentCTC = employeeInfo.getCurrentCTC(); // Per annual
		this.expectedCTC = employeeInfo.getExpactedCTC(); // Per annual
		this.designation = employeeInfo.getDesignation();
		this.organizationType = employeeInfo.getOrganizationType();
		this.currentOrganizationName = employeeInfo.getCurrentOrganizationName();
		this.currentLocation = employeeInfo.getCurrentLocation();
		this.jobProfile = employeeInfo.getJobProfile();
		this.resume = resumeLocation;
	}

	public EmployeeInfoDTO(String id, EmployeeInfo employeeInfo, String resumeLocation) {
		this.id = id;
		this.name = employeeInfo.getName();
		this.emailId = employeeInfo.getEmailId();
		this.mobileNumber = employeeInfo.getMobileNumber();
		this.fatherName = employeeInfo.getFatherName();
		this.motherName = employeeInfo.getMotherName();
		this.age = employeeInfo.getAge();
		this.dob = employeeInfo.getDob();
		this.currentCTC = employeeInfo.getCurrentCTC(); // Per annual
		this.expectedCTC = employeeInfo.getExpactedCTC(); // Per annual
		this.designation = employeeInfo.getDesignation();
		this.organizationType = employeeInfo.getOrganizationType();
		this.currentOrganizationName = employeeInfo.getCurrentOrganizationName();
		this.currentLocation = employeeInfo.getCurrentLocation();
		this.jobProfile = employeeInfo.getJobProfile();
		this.resume = resumeLocation;
		this.createTime = employeeInfo.getCreateTime();
		this.updateTime = employeeInfo.getUpdateTime();
	}

	private String id;// UUID
	private String name;
	private String emailId;
	private String mobileNumber;
	private String fatherName;
	private String motherName;
	private int age;
	private Date dob;
	private double currentCTC; // Per annual
	private double expectedCTC; // Per annual
	private String designation;
	private String organizationType;
	private String currentOrganizationName;
	private String currentLocation;
	private String jobProfile;
	private String resume;
	private Date createTime;
	private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public double getCurrentCTC() {
		return currentCTC;
	}

	public void setCurrentCTC(double currentCTC) {
		this.currentCTC = currentCTC;
	}

	public double getExpectedCTC() {
		return expectedCTC;
	}

	public void setExpectedCTC(double expectedCTC) {
		this.expectedCTC = expectedCTC;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getOrganizationType() {
		return organizationType;
	}

	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}

	public String getCurrentOrganizationName() {
		return currentOrganizationName;
	}

	public void setCurrentOrganizationName(String currentOrganizationName) {
		this.currentOrganizationName = currentOrganizationName;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getJobProfile() {
		return jobProfile;
	}

	public void setJobProfile(String jobProfile) {
		this.jobProfile = jobProfile;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}
}
