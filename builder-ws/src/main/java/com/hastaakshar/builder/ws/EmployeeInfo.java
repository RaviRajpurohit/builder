package com.hastaakshar.builder.ws;

import java.io.InputStream;
import java.util.Date;

/**
 * 
 * @author Ravi
 *
 */
public class EmployeeInfo {

	private String id;// UUID
	private String name;
	private String emailId;
	private String mobileNumber;
	private String fatherName;
	private String motherName;
	private int age;
	private Date dob;
	private double currentCTC; // Per annual
	private double expactedCTC; // Per annual
	private String designation;
	private String organizationType;
	private String currentOrganizationName;
	private String currentLocation;
	private String jobProfile;
	private InputStream resume;
	private String resumeFileExtension;
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

	public double getExpactedCTC() {
		return expactedCTC;
	}

	public void setExpactedCTC(double expactedCTC) {
		this.expactedCTC = expactedCTC;
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

	public InputStream getResume() {
		return resume;
	}

	public void setResume(InputStream resume) {
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

	public String getResumeFileExtension() {
		return resumeFileExtension;
	}

	public void setResumeFileExtension(String resumeFileExtension) {
		this.resumeFileExtension = resumeFileExtension;
	}
}
