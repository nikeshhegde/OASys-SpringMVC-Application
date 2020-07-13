package com.project.erp.serviceImpl.gstian.examcell;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.erp.dao.gstian.examcell.SubjectAllotmentDao;
import com.project.erp.model.SubjectAllotment;
import com.project.erp.service.gstian.examcell.SubjectAllotmentService;

@Service
public class SubjectAllotmentServiceImpl implements SubjectAllotmentService {

	@Autowired
	private SubjectAllotmentDao subjectAllotmentDao;
	
	@Transactional
	public void add(SubjectAllotment subject) {
		subjectAllotmentDao.add(subject);
	}

	@Transactional
	public void edit(SubjectAllotment subject) {
		subjectAllotmentDao.edit(subject);
	}

	@Transactional
	public void delete(int subjectId) {
		subjectAllotmentDao.delete(subjectId);
	}

	@Transactional(readOnly = true)
	public SubjectAllotment getSubjectAlloted(int subjectId) {
		return subjectAllotmentDao.getSubjectAlloted(subjectId);
	}

	@Transactional(readOnly = true)
	public List<SubjectAllotment> getAllSubjectAlloted() {
		return subjectAllotmentDao.getAllSubjectAlloted();
	}

	@Transactional(readOnly = true)
	public List<SubjectAllotment> subjectFetch(String branch, String semester) {
		return subjectAllotmentDao.subjectFetch(branch, semester);
	}

	@Transactional
	public List<SubjectAllotment> subjectFetch(String branch, String semester,String year) {
	return subjectAllotmentDao.subjectFetch(branch, semester, year);
	}

}
