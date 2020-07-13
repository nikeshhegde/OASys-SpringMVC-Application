package com.project.erp.controller.applicant;
 
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.project.erp.common.util.logging.InjectableLogger;
import com.project.erp.forms.applicant.FileUpload;
import com.project.erp.model.AdmissionUser1;
 
@Controller
public class FileUploadControllerApplicant {
 
	@InjectableLogger
	public Logger logger;

	
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String crunchifyDisplayForm() {
        return "uploadfile";
    }
 
    @RequestMapping(value = "/savefiles", method = RequestMethod.POST)
    public String crunchifySave(
            @ModelAttribute("uploadForm") FileUpload uploadForm,
            Model map,HttpSession session) throws IllegalStateException, IOException {
        
    	AdmissionUser1 admUser=(AdmissionUser1)session.getAttribute("userModel");
    	String newdir="ERP//Applicant Information//Applicant "+admUser.getId();
    	File directory=new File(newdir);
    	boolean dirFlag;
    	try {
    		   dirFlag = directory.mkdir();
    		} catch (SecurityException Se) {
    		System.out.println("Error while creating directory in Java:" + Se);
    		}
    	

    		//Read more: http://javarevisited.blogspot.com/2011/12/create-file-directory-java-example.html#ixzz3T1kIcm8E
    	
    	
    	
    	String saveDirectory = newdir+"//";
    	
 
        List<MultipartFile> crunchifyFiles = uploadForm.getFiles();
 
        List<String> fileNames = new ArrayList<String>();
 
        if (null != crunchifyFiles && crunchifyFiles.size() > 0) {
            for (MultipartFile multipartFile : crunchifyFiles) {
 
                String fileName = multipartFile.getOriginalFilename();
                if (!"".equalsIgnoreCase(fileName)) {
                    // Handle file content - multipartFile.getInputStream()
                    multipartFile
                            .transferTo(new File(saveDirectory + fileName));
                    fileNames.add(fileName);
                }
            }
        }
        
        
		
		String fullName="";
		logger.debug("Gender is "+admUser.getAdmissionUserGender());
		if(admUser.getAdmissionUserGender().equalsIgnoreCase("Male"))
		{
			fullName+="Mr. ";
		}
		else
		{
			fullName+="Ms. ";
					
		}
		
		fullName+=admUser.getAdmissionUserSurName()+" ";
		fullName+=admUser.getAdmissionUserFname()+" ";
		fullName+=admUser.getAdmissionUserFatherName();
		logger.debug("Full name is "+fullName);
		map.addAttribute("fullName", fullName);
 
        map.addAttribute("files", fileNames);
        return "applicant/Admission/fe6";
    }
}