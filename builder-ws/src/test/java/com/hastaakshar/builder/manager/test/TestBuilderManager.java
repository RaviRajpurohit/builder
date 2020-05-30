package com.hastaakshar.builder.manager.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hastaakshar.builder.common.SystemFailureException;
import com.hastaakshar.builder.manager.BuilderManager;
import com.hastaakshar.builder.util.BuilderUtil;
import com.hastaakshar.builder.ws.EmployeeInfo;

public class TestBuilderManager {

	private BuilderManager builderManager;

	@BeforeTest
	public void initialize() {
		System.setProperty(BuilderUtil.HASTAAKSHAR_HOME, "src/test/resources");
		builderManager = new BuilderManager();
	}

	@Test
	public void basicFlowTestForPDF() throws SystemFailureException, FileNotFoundException {
		EmployeeInfo employeeInfo = new EmployeeInfo();

		employeeInfo.setName("Ravi Rajpurohit");
		employeeInfo.setEmailId("ravirajpurohit29@gmail.com");
		employeeInfo.setMobileNumber("7727882514");
		employeeInfo.setDob(new Date(783369000000l));
		employeeInfo.setResume(new FileInputStream(new File("src/test/resources/old-resume/Ravi_Rajpurohit.pdf")));
		employeeInfo.setResumeFileExtension("pdf");
		builderManager.storeEmployeeInfo(employeeInfo);
	}

	@Test
	public void basicFlowTestForDOC() throws SystemFailureException, FileNotFoundException {
		EmployeeInfo employeeInfo = new EmployeeInfo();

		employeeInfo.setName("Ravi Rajpurohit");
		employeeInfo.setEmailId("ravirajpurohit29@gmail.com");
		employeeInfo.setMobileNumber("7727882514");
		employeeInfo.setDob(new Date(783369000000l));
		employeeInfo.setResume(new FileInputStream(new File("src/test/resources/old-resume/resume.doc")));
		employeeInfo.setResumeFileExtension("doc");
		builderManager.storeEmployeeInfo(employeeInfo);
	}

	@Test
	public void basicFlowTestForText() throws SystemFailureException, FileNotFoundException {
		EmployeeInfo employeeInfo = new EmployeeInfo();

		employeeInfo.setName("Ravi Rajpurohit");
		employeeInfo.setEmailId("ravirajpurohit29@gmail.com");
		employeeInfo.setMobileNumber("7727882514");
		employeeInfo.setDob(new Date(783369000000l));
		employeeInfo.setResume(new FileInputStream(new File("src/test/resources/old-resume/resume.txt")));
		employeeInfo.setResumeFileExtension("txt");
		builderManager.storeEmployeeInfo(employeeInfo);
	}
}
