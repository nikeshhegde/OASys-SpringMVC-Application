package com.project.erp.daoImpl.gstian.examcell;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.erp.dao.gstian.examcell.FileUploadDao;
import com.project.erp.model.FileUpload;
import com.project.erp.service.gstian.examcell.MasterTableProcessService;

@Repository
@Transactional
public class FileUploadDaoImpl implements FileUploadDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private MasterTableProcessService processor;

	public void add(FileUpload newFile) {
		getSession().save(newFile);
	}

	
	public void delete(long fileId) {
		Session session=getSession();
		session.beginTransaction();
		session.delete(getFileAlloted(fileId));
		session.getTransaction().commit();
		System.out.println("After delete");
	}

	public FileUpload getFileAlloted(long fileId) {
		return (FileUpload) getSession().get(FileUpload.class, fileId);
	}

	@SuppressWarnings("unchecked")
	public List<FileUpload> getAllFilesAlloted() {
		return getSession().createCriteria(FileUpload.class).list();

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Session getSession() {

		return sessionFactory.openSession();
	}

	public void convert(long fileId, String filelocation, String tablename) throws FileNotFoundException{
		Session session=getSession();
		
			try {
				processor.process(filelocation,tablename,session);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.close();
	}

}
