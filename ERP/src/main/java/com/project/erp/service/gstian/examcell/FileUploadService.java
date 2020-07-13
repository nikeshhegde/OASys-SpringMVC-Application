package com.project.erp.service.gstian.examcell;

import java.io.FileNotFoundException;
import java.util.List;

import com.project.erp.model.FileUpload;


public interface FileUploadService {

	public void add(FileUpload newFile);
	public void delete(long fileId);
	public FileUpload getFileAlloted(long fileId);
	public List<FileUpload> getAllFilesAlloted();
	public void convert(long fileId, String filelocation, String tablename) throws FileNotFoundException;

}
