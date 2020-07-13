package com.project.erp.serviceImpl.gstian.examcell;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.erp.dao.gstian.examcell.FileUploadDao;
import com.project.erp.model.FileUpload;
import com.project.erp.service.gstian.examcell.FileUploadService;

@Service
public class FileUploadServiceImpl implements FileUploadService {
	
	@Autowired
	private FileUploadDao fileUploadDao;

	@Transactional
	public void add(FileUpload newFile) {
		fileUploadDao.add(newFile);
	}

	@Transactional
	public void delete(long fileId) {
		fileUploadDao.delete(fileId);
	}

	@Transactional(readOnly = true)
	public FileUpload getFileAlloted(long fileId) {
		return fileUploadDao.getFileAlloted(fileId);
	}

	@Transactional(readOnly = true)
	public List<FileUpload> getAllFilesAlloted() {
		return fileUploadDao.getAllFilesAlloted();
	}

	@Transactional
	public void convert(long fileId, String filelocation, String tablename) throws FileNotFoundException {
		fileUploadDao.convert(fileId, filelocation, tablename);
	}

}
