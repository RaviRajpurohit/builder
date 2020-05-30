package com.hastaakshar.builder.dao;

import java.sql.Timestamp;
import java.sql.Types;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class BuilderDAO {
	
	private static final String QUERY_TO_STORE_EMPLOYEE_INFO = "INSERT INTO EMPLOYEE_INFO (ID,NAME,EMAIL_ID,MOBILE_NUMBER,FATHER_NAME,MOTHER_NAME,AGE,DATE_OF_BIRTH,CURRENT_CTC,EXPECTED_CTC,DESIGNATION,ORGANIZATION_TYPE,CURRENT_ORGANIZATION_NAME,CURRENT_LOCATION,JOB_PROFILE,RESUME_LOCATION,CREATE_TIME) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	private JdbcTemplate jdbcTemplate;
	private static final Logger logger = LoggerFactory.getLogger(BuilderDAO.class);

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void storeEmpolyeeInfo(EmployeeInfoDTO employeeInfoDTO) {
		logger.debug("Executing::BuilderDAO.storeEmployeeInfo()...");
		
		/*
		 * ID,
		   NAME,
		   EMAIL_ID,
		   MOBILE_NUMBER,
		   FATHER_NAME,
		   MOTHER_NAME,
		   AGE,
		   DATE_OF_BIRTH,
		   CURRENT_CTC,
		   EXPECTED_CTC,
		   DESIGNATION,
		   ORGANIZATION_TYPE,
		   CURRENT_ORGANIZATION_NAME,
		   CURRENT_LOCATION,
		   JOB_PROFILE,
		   RESUME_LOCATION,
		   CREATE_TIME,
		   -- UPDATE_TIME
		 */
		Object[] parameters = new Object[] {
				employeeInfoDTO.getId(),
				employeeInfoDTO.getName(),
				employeeInfoDTO.getEmailId(),
				employeeInfoDTO.getMobileNumber(),
				employeeInfoDTO.getFatherName(),
				employeeInfoDTO.getMotherName(),
				employeeInfoDTO.getAge(),
				employeeInfoDTO.getDob() != null ? new Timestamp(employeeInfoDTO.getDob().getTime()) : null,
				employeeInfoDTO.getCurrentCTC(),
				employeeInfoDTO.getExpectedCTC(),
				employeeInfoDTO.getDesignation(),
				employeeInfoDTO.getOrganizationType(),
				employeeInfoDTO.getCurrentOrganizationName(),
				employeeInfoDTO.getCurrentLocation(),
				employeeInfoDTO.getJobProfile(),
				employeeInfoDTO.getResume(),
				new Timestamp(employeeInfoDTO.getCreateTime().getTime())
		};

		jdbcTemplate.update(QUERY_TO_STORE_EMPLOYEE_INFO, parameters,
				new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
						Types.INTEGER, Types.TIMESTAMP, Types.FLOAT, Types.FLOAT, Types.VARCHAR, Types.VARCHAR,
						Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP });

		logger.debug("Exiting::BuilderDAO.storeEmployeeInfo()...");
	}
}
