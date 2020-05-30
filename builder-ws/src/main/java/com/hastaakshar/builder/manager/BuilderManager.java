/**
 * 
 */
package com.hastaakshar.builder.manager;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.hastaakshar.builder.common.SystemFailureException;
import com.hastaakshar.builder.dao.BuilderDAO;
import com.hastaakshar.builder.dao.EmployeeInfoDTO;
import com.hastaakshar.builder.util.BuilderUtil;
import com.hastaakshar.builder.ws.EmployeeInfo;

/**
 * @author Ravi
 *
 */
public class BuilderManager {

	private BuilderDAO builderDAO;
	private final String homeLocation;
	private static final Logger logger = LoggerFactory.getLogger(BuilderManager.class);

	public BuilderManager() {
		homeLocation = System.getProperty("HASTAAKSHAR_HOME");
	}

	public void setBuilderDAO(BuilderDAO builderDAO) {
		this.builderDAO = builderDAO;
	}

	@Transactional(rollbackFor = { Exception.class })
	public EmployeeInfo storeEmployeeInfo(EmployeeInfo employeeInfo) throws SystemFailureException {
		logger.info("Executing::BuilderManager.storeEmployeeInfo()...");
		InputStream resume = employeeInfo.getResume();

		String currentId = BuilderUtil.genrateUUID();
		String resumeLocation = homeLocation + "/" + currentId + "." + employeeInfo.getResumeFileExtension();
		try {
			FileOutputStream newResume = new FileOutputStream(resumeLocation);
			int b;
			while ((b = resume.read()) != -1) {
				newResume.write(b);
			}
			newResume.close();
			resume.close();
		} catch (Exception e) {
			logger.error("Error occurred while copy resume file to new file.", e);
			throw new SystemFailureException("Error occurred while copy resume file to new file.", e);
		}

		employeeInfo.setCreateTime(new Date());

		EmployeeInfoDTO employeeInfoDTO = new EmployeeInfoDTO(currentId, employeeInfo, resumeLocation);

		builderDAO.storeEmpolyeeInfo(employeeInfoDTO);

		employeeInfo.setId(currentId);
		logger.info("Exiting::BuilderManager.storeEmployeeInfo()...");
		return employeeInfo;
	}

}
