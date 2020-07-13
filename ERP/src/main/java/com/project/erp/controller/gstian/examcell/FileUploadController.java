package com.project.erp.controller.gstian.examcell;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.project.erp.model.FileUpload;
import com.project.erp.service.gstian.examcell.FileUploadService;

@Controller
@PreAuthorize("hasRole('EXAMCELLCOORD')")
@RequestMapping("/fileupload")
public class FileUploadController {
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping("/listofuploaded")
	public String listOfUploadedFiles(Map<String,Object> map, Model model){
		
		model.addAttribute("uploadFile", new FileUpload());
		map.put("fileUpload",new FileUpload());
		map.put("filesUploadList", fileUploadService.getAllFilesAlloted());
		return "/gstian/examcell/fileupload/successful";
	}
	
	@RequestMapping("/getfile/{fileId}")
	public String getFileUploaded(@PathVariable long fileId, Map<String,Object> map){
		
		FileUpload fileUploaded=fileUploadService.getFileAlloted(fileId);
		map.put("fileuploaded", fileUploaded);
		return "/gstian/examcell/fileupload/uploadForm";
		
	}
	
	//successful jsp page is basically a list page rather than success message page
	
	/*@RequestMapping("/savefile")
	public String addFile(@ModelAttribute("fileUpload") FileUpload fileUpload, BindingResult result){
		
		fileUploadService.add(fileUpload);
		
		return "redirect:successful ";
	}*/
	
	
	@RequestMapping("/deletefile/{fileId}")    // instead of /delete/{fileId}
	public String deleteFile(@PathVariable("fileId") String fileId){
		
		FileUpload uploadFile=fileUploadService.getFileAlloted(Long.parseLong(fileId));
		String locationOfFile=uploadFile.getLocation();
		
		try{
			File file=new File(locationOfFile);
			file.delete();
		}catch(Exception e){
			System.out.println("Exception!!");
			return "redirect:/gstian/examcell/fileupload/listofuploaded";
		}
		System.out.println(uploadFile.getFileId());
		fileUploadService.delete(uploadFile.getFileId());
		return "redirect:/gstian/examcell/fileupload/listofuploaded";
	}
	
	
	/*@RequestMapping(value="/uploadfile", method=RequestMethod.GET)
	public String UploadForm(Model model){
		model.addAttribute("uploadFile", new FileUpload()); 
		return "/fileupload/uploadForm";
	}*/
	
	//Till now nothing has been done for checking whether file being uploaded is .csv or not
	//that needs to be checked
	//inbuilt method .getOriginalFileName() returns name with contentType at the end so simple java logic to check
	
	@RequestMapping(value="/fileuploaded", method=RequestMethod.POST)
	public String processUpload(@ModelAttribute("uploadFile") FileUpload uploadFile, BindingResult result){
		
		String filelocation;
		uploadFile.setLocation(uploadFile.getLocation()+uploadFile.getFilename()+".csv");
		uploadFile.setDateCreated(new Date());
		fileUploadService.add(uploadFile);
		filelocation=uploadFile.getLocation();
		System.out.println(filelocation);
		//String saveDirectory = uploadFile.getLocation();//  "C:/Users/Raghuram/Desktop/  this has been set in value field of form as default"
		MultipartFile multipartFile =uploadFile.getFile();	//this ensures uploading of file
		//String filename=uploadFile.getFilename()+".csv"; //the file name as given by the user without .csv being mentioned
		 if (null != multipartFile && multipartFile.getSize() > 0) {
				try {
					multipartFile.transferTo(new File(filelocation));
				} catch (IllegalStateException e) {
					e.printStackTrace();
					return "/gstian/examcell/fileupload/unsuccessful";
					
				} catch (IOException e) {
					// to do certain tasks if necessary
					e.printStackTrace();
					return "/gstian/examcell/fileupload/unsuccessful";
				}
			
		 }
	            
		
		return "redirect:/gstian/examcell/fileupload/listofuploaded";
		
	}
	
	
	@RequestMapping(value="/convert/{fileId}")
	public String convertToDatabase(@PathVariable("fileId") long fileId) throws FileNotFoundException{
		
		FileUpload fileconvert=(FileUpload)fileUploadService.getFileAlloted(fileId);
		String filelocation=fileconvert.getLocation();
		//String filelocation="C:/Users/Raghuram/Desktop/wid.csv";
		//String tablename=fileconvert.getFilename();
		String tablename="";
		fileUploadService.convert(fileId, filelocation, tablename);
		
		return "redirect:/gstian/examcell/fileupload/listofuploaded";
	}
	
	
	

}
