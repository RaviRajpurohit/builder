package com.hastaakshar.builder.ws;

import com.hastaakshar.builder.common.InvalidDataException;
import com.hastaakshar.builder.common.SystemFailureException;
import com.hastaakshar.builder.manager.BuilderManager;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Ravi
 */
@Path("/builder")
public class BuilderService {

    private static final Logger logger = LoggerFactory.getLogger(BuilderService.class);

    private final BuilderManager builderManager;

    public BuilderService() {
        builderManager = ApplicationRuntimeContext.getBuilderManager();
    }

    @PUT
    public void test(){
        logger.info("builder service is up. please check other errors.");
    }

    @POST
    @Consumes("multipart/form-data")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response storeData(MultipartFormDataInput input) {

        if (input == null) {
            logger.error("Required parameter is missing.");
            return Response.ok("Input data is invalid.").status(400).build();
        }

        try {
            EmployeeInfo employeeInfo = this.getEmpoyeeInfo(input);

            EmployeeInfo storedEmployeeInfo = builderManager.storeEmployeeInfo(employeeInfo);

            return Response.ok(storedEmployeeInfo).status(200).build();
        } catch (InvalidDataException e) {
            logger.error("Input parameter : {}", input, e);
            return Response.ok("Input data is invalid.").status(400).build();
        } catch (SystemFailureException e) {
            logger.error("", e);
            return Response.ok("Error occurred while storing employee info. please check server logs.").status(500)
                    .build();
        }
    }

    private EmployeeInfo getEmpoyeeInfo(MultipartFormDataInput input) throws InvalidDataException {
        try {

            Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
            List<InputPart> resumeInputParts = uploadForm.get("resume");
            List<InputPart> nameInputParts = uploadForm.get("name");
            List<InputPart> emailIdInputParts = uploadForm.get("email");
            List<InputPart> phoneNumberInputParts = uploadForm.get("phone");
            List<InputPart> dobInputParts = uploadForm.get("dob");

            if (resumeInputParts == null || resumeInputParts.isEmpty() || nameInputParts == null
                    || nameInputParts.isEmpty() || emailIdInputParts == null || emailIdInputParts.isEmpty()
                    || phoneNumberInputParts == null || phoneNumberInputParts.isEmpty() || dobInputParts == null
                    || dobInputParts.isEmpty()) {
                throw new InvalidDataException(
                        "Invalid parameters, Either resume file does not attached or name, email, phone or dob not provided. input : "
                                + input);
            }
            EmployeeInfo employeeInfo = new EmployeeInfo();

            InputPart nameInputPart = nameInputParts.iterator().next();
            if (nameInputPart.getBodyAsString() == null || nameInputPart.getBodyAsString().isEmpty()) {
                throw new InvalidDataException("Invalid parameter, name parameter value not provided.");
            }
            employeeInfo.setName(nameInputPart.getBodyAsString());

            InputPart emailInputPart = emailIdInputParts.iterator().next();
            if (emailInputPart.getBodyAsString() == null || emailInputPart.getBodyAsString().isEmpty()) {
                throw new InvalidDataException("Invalid parameter, email parameter value not provided.");
            }
            employeeInfo.setEmailId(emailInputPart.getBodyAsString());

            InputPart phoneInputPart = phoneNumberInputParts.iterator().next();
            if (phoneInputPart.getBodyAsString() == null || phoneInputPart.getBodyAsString().isEmpty()) {
                throw new InvalidDataException("Invalid parameter, phone parameter value not provided.");
            }
            employeeInfo.setEmailId(emailInputPart.getBodyAsString());

            InputPart dobInputPart = dobInputParts.iterator().next();
            if (dobInputPart.getBodyAsString() == null || dobInputPart.getBodyAsString().isEmpty()) {
                throw new InvalidDataException("Invalid parameter, phone parameter value not provided.");
            }
            Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(dobInputPart.getBodyAsString());
            employeeInfo.setDob(dob);

            InputPart resumeInputPart = resumeInputParts.iterator().next();

            MultivaluedMap<String, String> header = resumeInputPart.getHeaders();
            String fileType = getFileType(header);

            // convert the uploaded file to inputstream
            InputStream resumeAsInputStream = resumeInputPart.getBody(InputStream.class, null);
            employeeInfo.setResume(resumeAsInputStream);
            employeeInfo.setResumeFileExtension(fileType);

            return employeeInfo;
        } catch (IOException | ParseException e) {
            logger.error("Error occurred while write data from parameter.", e);
            throw new InvalidDataException("Error occurred while write data from parameter.", e);
        }
    }

	/**
            * header sample { Content-Type=[image/png], Content-Disposition=[form-data;
	 * name="file"; filename="filename.extension"] }
	 **/
    private String getFileType(MultivaluedMap<String, String> header) {

        String[] contentDisposition = header.getFirst("Content-Disposition").split(";");

        for (String filename : contentDisposition) {
            if ((filename.trim().startsWith("filename"))) {

                String[] name = filename.split("=");

                String finalFileName = name[1].trim().replaceAll("\"", "");
                return finalFileName.substring(finalFileName.lastIndexOf("."));
            }
        }
        logger.warn("Resume File does not have name");
        return "unknown";
    }

}
