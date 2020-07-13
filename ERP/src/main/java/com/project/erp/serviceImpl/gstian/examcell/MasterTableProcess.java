package com.project.erp.serviceImpl.gstian.examcell;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.bytecode.opencsv.CSVReader;

import com.project.erp.dao.gstian.examcell.MasterTableAnalysisDao;
import com.project.erp.service.gstian.examcell.MasterTableProcessService;

@Service
public class MasterTableProcess implements MasterTableProcessService {

	public String location;
	public String fileName;
	private String suffix=".csv";
	private CSVReader reader;
	
	@Autowired
	private MasterTableAnalysisDao analyzer;

	/*
	public MasterTableProcess(String location, String fileName, Session session) throws FileNotFoundException {
		this.location = location;
		this.fileName = fileName;
		reader = new CSVReader(new FileReader(this.location + this.fileName+this.suffix), ',');
		
	}*/

	/* (non-Javadoc)
	 * @see com.exam.service.MasterTableProcessService#process()
	 */
	public void process(String location,String fileName,Session session) throws IOException
	{
		reader = new CSVReader(new FileReader(location + fileName), ',');
		
		 //read all lines at once
        List<String[]> records = reader.readAll();
         
        Iterator<String[]> iterator = records.iterator();
        //skip header row
        iterator.next();
         
        while(iterator.hasNext()){
            String[] record = iterator.next();
            
            /*
            dump contents -> master table
            if student_details!exist -> add
            if user!exist -> add
            compare against cutoffs;
            if less, -> kteligible
            */
            analyzer.populateMasterTable(record,session);
            analyzer.studentDetailsManage(record,session);
            analyzer.usersManage(record,session);
            analyzer.ktclassify(record,session);
            
            
         }
         
        reader.close();
         
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
