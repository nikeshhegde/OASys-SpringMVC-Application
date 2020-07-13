package com.project.erp.service.gstian.examcell;

import java.io.IOException;

import org.hibernate.Session;

public interface MasterTableProcessService {

	
	
	public abstract void process(String location, String fileName,Session session) throws IOException;
	
	

}